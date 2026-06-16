package com.example.payment.bdd.loader;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoPixDataLoader {

    private static final String ENDPOINT = "/transacao-pix/";

    @Autowired
    private WireMockServer wireMockServer;

    public void loaderResponseSuccess(String codigoTransacao) {

        var response = """
                {
                	"codigoTrancacao": "%s",
                	"codigoPessoa": "0af62598-25cd-4007-ad1e-c271b0a645ed",
                	"valorTrancacao": 64206.00,
                	"dataTrancacao": "2024-05-14T12:53:08.142",
                	"codigoBeneficiario": "161bed85-7b6b-4804-921e-388cdf707b05",
                	"mensagemTransacao": "PIX pagamento do carro"
                }
                """.formatted(codigoTransacao);

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo(ENDPOINT + codigoTransacao))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(response)));

    }

    public void loaderResponseError(String codigoTransacao) {
        var response = """
                {
                	"messages": [
                		{
                			"code": "404",
                			"message": "[404] during ..."
                		}
                	]
                }
                """;

        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo(ENDPOINT + codigoTransacao))
                .willReturn(WireMock.aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", "application/json")
                        .withBody(response)));
    }

    public void clean() {
        wireMockServer.resetAll();
    }
}
