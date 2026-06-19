package com.example.payment.bdd.scenario;

import com.example.payment.bdd.common.RestClient;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class TransacaoPixPostScenario {

    private static final String BASE_URI = "http://localhost";
    private static final String ENDPOINT = "/transacao-pix";

    private final RestClient restClient;

    private String requestBody;
    private Response response;

    public TransacaoPixPostScenario(@LocalServerPort int serverPort) {
        this.restClient = new RestClient(BASE_URI, serverPort);
    }

    public void addRequestBody(String jsonBody) {
        this.requestBody = jsonBody;
    }

    public Response criarTransacaoPix() {
        restClient.addBody(requestBody);
        return restClient.executePost(ENDPOINT);
    }

    public void addResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

}
