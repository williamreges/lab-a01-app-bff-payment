package com.example.payment.bdd.scenario;

import com.example.payment.bdd.common.RestClient;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ScenarioScope
public class TransacaoPixGetScenario {

    private static final String BASE_URI = "http://localhost";
    private static final String ENDPOINT = "/transacao-pix/";

    @LocalServerPort
    private int serverPort;

    private RestClient restClient;

    private Response response;

    @PostConstruct
    public void init(){
        this.restClient = new RestClient(BASE_URI, serverPort);
    }

    public void gerarMassa(String codigoTransacao) {
//        var newEntity = TransacaoPixEntityTestDataBuilder.builder()
//                .comCodigoTrancacao(UUID.fromString(codigoTransacao))
//                .build();
//        repositoryJPA
//                .save(newEntity);
    }

    public void deleteAll() {

    }

    public void addReponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public Response obterTransacaoPixPorId(String codigoTransacao) {
        return restClient.executeGet(ENDPOINT, codigoTransacao);
    }
}
