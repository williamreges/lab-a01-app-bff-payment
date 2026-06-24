package com.example.payment.bdd.steps;

import com.example.payment.bdd.scenario.TransacaoPixDeleteScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class TransacaoPixDeleteStepdefs {

    @Autowired
    private TransacaoPixDeleteScenario pixDeleteScenario;

    @Given("que existe uma transação Pix com o id {string} paa deletar")
    public void queExisteUmaTransaçãoPixComOIdPaaDeletar(String arg0) {
        pixDeleteScenario.existeTransacaoPix(arg0);
    }


    @When("eu envio uma requisição para deletar a transação Pix pelo id {string}")
    public void euEnvioUmaRequisicaoParaDeletarATransacaoPix(String codigoTransacao) {
        var response = pixDeleteScenario.removeTransacaoPix(codigoTransacao);
        pixDeleteScenario.addResponse(response);
    }

    @Then("o sistema deve retornar confirmação de deleção com sucesso")
    public void oSistemaDeveRetornarConfirmacaoDeDelecaoComSucesso() {
        Assertions.assertEquals(204, pixDeleteScenario.getResponse().statusCode());
    }

    @Then("o sistema deve retornar um erro informando que a transação não foi encontrada para deletar")
    public void oSistemaDeveRetornarUmErroInformandoQueATransacaoNaoFoiEncontrada() {
        Assertions.assertEquals(204, pixDeleteScenario.getResponse().statusCode());
    }

}
