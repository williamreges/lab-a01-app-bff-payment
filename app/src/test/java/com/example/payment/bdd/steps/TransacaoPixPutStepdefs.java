package com.example.payment.bdd.steps;

import com.example.payment.bdd.scenario.TransacaoPixPutScenario;
import com.example.payment.infraestructure.exception.model.ResponseExceptionCustom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class TransacaoPixPutStepdefs {


    @Autowired
    private TransacaoPixPutScenario pixPutScenario;

    @Given("que existe uma transação Pix com o id {string} para atualizar")
    public void queExisteUmaTransacaoPixComOId(String codigoTransacao) {
        pixPutScenario.existeTransacaoPix(codigoTransacao);
    }

    @And("que possuo os dados válidos para atualizar a transação Pix")
    public void quePossuoOsDadosValidosParaAtualizarATransacaoPix(String dto) {
        pixPutScenario.addRequestBody(dto);
    }

    @When("eu envio uma requisição com id {string} para atualizar a transação Pix")
    public void euEnvioUmaRequisicaoParaAtualizarATransacaoPix(String codigoTransacao) {
        var response = pixPutScenario.alterarTransacaoPix(codigoTransacao);
        pixPutScenario.addResponse(response);
    }

    @Then("o sistema deve retornar o status de transação Pix atualizada com sucesso")
    public void oSistemaDeveRetornarOsDadosDaTransacaoPixAtualizadaComSucesso() {
        pixPutScenario.getResponse().then().assertThat().statusCode(200);
    }


    @Then("o sistema deve retornar um erro informando que a transação a atualizar não foi encontrada")
    public void oSistemaDeveRetornarUmErroInformandoQueATransacaoNaoFoiEncontrada() {
        pixPutScenario.getResponse().then().assertThat().statusCode(404);
        Assertions.assertNotNull(pixPutScenario.getResponse().as(ResponseExceptionCustom.class));
    }

}
