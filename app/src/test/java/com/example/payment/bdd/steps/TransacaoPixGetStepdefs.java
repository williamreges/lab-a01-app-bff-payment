package com.example.payment.bdd.steps;

import com.example.payment.bdd.scenario.TransacaoPixGetScenario;
import com.example.payment.entrypoint.model.response.TransacaoPixResponse;
import com.example.payment.infraestructure.exception.model.ResponseExceptionCustom;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class TransacaoPixGetStepdefs {


    @Autowired
    private TransacaoPixGetScenario pixGetScenario;


    @Given("que existe uma transação Pix com o id {string}")
    public void queExisteUmaTransaçãoPixComOId(String codigoTransacao) {
        pixGetScenario.gerarMassa(codigoTransacao);
    }

    @When("eu buscar a transação Pix pelo id {string}")
    public void euBuscarATransaçãoPixPeloId(String codigoTransacao) {
        var response = pixGetScenario.obterTransacaoPixPorId(codigoTransacao);
        pixGetScenario.addReponse(response);
    }

    @Then("o sistema deve retornar os dados da transação Pix com sucesso")
    public void oSistemaDeveRetornarOsDadosDaTransaçãoPixComSucesso() {
        pixGetScenario.getResponse().then().assertThat().statusCode(200);
        var responseDTO = pixGetScenario.getResponse().as(TransacaoPixResponse.class);
        Assertions.assertNotNull(responseDTO);
    }

    @Then("o sistema deve retornar um erro informando que a transação não foi encontrada")
    public void oSistemaDeveRetornarUmErroInformandoQueATransaçãoNãoFoiEncontrada() {
        pixGetScenario.getResponse().then().assertThat().statusCode(404);
        var responseExceptionDTO = pixGetScenario.getResponse().as(ResponseExceptionCustom.class);
        Assertions.assertNotNull(responseExceptionDTO);
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
        pixGetScenario.deleteAll();
    }

}
