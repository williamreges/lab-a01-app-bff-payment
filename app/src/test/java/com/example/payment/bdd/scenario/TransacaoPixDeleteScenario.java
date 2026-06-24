
package com.example.payment.bdd.scenario;

import com.example.payment.bdd.common.RestClient;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class TransacaoPixDeleteScenario {

    private static final String BASE_URI = "http://localhost";
    private static final String ENDPOINT = "/transacao-pix/{id}";
    private final RestClient restClient;
    private Response response;

    public TransacaoPixDeleteScenario(@LocalServerPort int serverPort) {
        this.restClient = new RestClient(BASE_URI, serverPort);
    }

    public void existeTransacaoPix(String codigoTransacao) {
        // Aqui você pode implementar a lógica para garantir que a transação Pix exista antes de tentar atualizá-la.
        // Isso pode envolver criar uma transação Pix usando o endpoint POST ou verificar se ela já existe no sistema.
    }

    public Response removeTransacaoPix(String id) {
        return restClient.executeDelete(ENDPOINT, id);
    }

    public void addResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
