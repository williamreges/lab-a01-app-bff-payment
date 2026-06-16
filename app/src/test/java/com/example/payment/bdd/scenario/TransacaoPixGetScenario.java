package com.example.payment.bdd.scenario;

import com.example.payment.bdd.common.RestClient;
import com.example.payment.bdd.loader.TransacaoPixDataLoader;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class TransacaoPixGetScenario {

    private static final String BASE_URI = "http://localhost";
    private static final String ENDPOINT = "/transacao-pix/{id}";

    private final TransacaoPixDataLoader dataLoader;

    private final RestClient restClient;

    private Response response;

    public TransacaoPixGetScenario(@LocalServerPort int serverPort, TransacaoPixDataLoader dataLoader) {
        this.dataLoader = dataLoader;
        this.restClient = new RestClient(BASE_URI, serverPort);
    }


    public void beforeScenario() {
        dataLoader.clean();
    }

    public void generateResponseSuccess(String codigoTransacao) {
        dataLoader.loaderResponseSuccess(codigoTransacao);
    }

    public void generateResponseError(String codigoTransacao) {
        dataLoader.loaderResponseError(codigoTransacao);
    }

    public void addReponse(Response response) {
        this.response = response;
    }

    public Response obterTransacaoPixPorId(String codigoTransacao) {
        return restClient.executeGet(ENDPOINT, codigoTransacao);
    }

    public Response getResponse() {
        return response;
    }

    public void afterScenario() {
        dataLoader.clean();
    }


}
