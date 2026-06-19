package com.example.payment.bdd.steps;

import com.example.payment.bdd.scenario.TransacaoPixPostScenario;
import com.example.payment.infraestructure.exception.model.ResponseExceptionCustom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.UUID;

public class TransacaoPixPostStepdefs {

    private final TransacaoPixPostScenario pixPostScenario;

    public TransacaoPixPostStepdefs(TransacaoPixPostScenario pixPostScenario) {
        this.pixPostScenario = pixPostScenario;
    }

    @Given("que possuo os dados válidos de uma transação Pix")
    public void quePossuoOsDadosValidosDeUmaTransacaoPix(String jsonBody) {
        pixPostScenario.addRequestBody(jsonBody);
    }

    @When("eu envio uma requisição para criar a transação Pix")
    public void euEnvioUmaRequisicaoParaCriarATransacaoPix() {
        var response = pixPostScenario.criarTransacaoPix();
        pixPostScenario.addResponse(response);
    }

    @Then("o sistema deve retornar os dados da transação Pix criada com sucesso")
    public void oSistemaDeveRetornarOsDadosDaTransacaoPixCriadaComSucesso() {
        pixPostScenario.getResponse().then().assertThat().statusCode(201);
        var codigoTransacao = UUID.fromString(pixPostScenario.getResponse().asString());
        Assertions.assertNotNull(codigoTransacao);
    }

    @Given("que possuo dados nulos como codigoPessoa e valorTransacao para uma transação Pix")
    public void quePossuoDadosInvalidosParaUmaTransacaoPix(String jsonBodyInvalid) {
        pixPostScenario.addRequestBody(jsonBodyInvalid);
    }

    @Then("o sistema deve retornar um erro informando que os dados são inválidos")
    public void oSistemaDeveRetornarUmErroInformandoQueOsDadosSaoInvalidos() {
        pixPostScenario.getResponse().then().assertThat().statusCode(400);
        var responseExceptionDTO = pixPostScenario.getResponse().as(ResponseExceptionCustom.class);
        Assertions.assertNotNull(responseExceptionDTO);
    }

}
