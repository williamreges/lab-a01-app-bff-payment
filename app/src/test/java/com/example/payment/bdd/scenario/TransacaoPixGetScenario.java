package com.example.payment.bdd.scenario;

import com.example.payment.bdd.common.RestClient;
import com.example.payment.bdd.loader.TransacaoPixDataLoader;
import io.cucumber.spring.ScenarioScope;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ScenarioScope
public class TransacaoPixGetScenario {

    private static final String BASE_URI = "http://localhost";
    private static final String ENDPOINT = "/transacao-pix/{id}";

    @LocalServerPort
    private int serverPort;

    @Autowired
    private TransacaoPixDataLoader dataLoader;

    private RestClient restClient;

    private Response response;


    @PostConstruct
    public void init() {
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

    public void afterScenario(){
        dataLoader.clean();
    }


}
