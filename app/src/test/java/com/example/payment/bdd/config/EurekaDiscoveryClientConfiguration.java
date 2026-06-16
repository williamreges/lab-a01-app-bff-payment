package com.example.payment.bdd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/***
 * Configuração de DiscoveryClient para testes que implementa a descoberta de serviços.
 * Mapeia o serviço de repositório (app-repository-payment) para localhost:8100, permitindo que os testes
 * se comuniquem com a instância simulada via WireMock através da interface Feign.
 */
@Configuration
public class EurekaDiscoveryClientConfiguration implements DiscoveryClient {

    @Value("${name.service.repository}")
    private String nameService;

    @Override
    public String description() {
        return "Test DiscoveryClient that maps app-repository-payment to localhost:8100";
    }

    @Override
    public List<ServiceInstance> getInstances(String serviceId) {
        if (nameService.equals(serviceId)) {
            var instance = new DefaultServiceInstance(serviceId + "-1", serviceId, "localhost", 8100, false);
            return List.of(instance);
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getServices() {
        return List.of("app-repository-payment");
    }
}
