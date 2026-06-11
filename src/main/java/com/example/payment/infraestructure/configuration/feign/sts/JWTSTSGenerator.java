package com.example.payment.infraestructure.configuration.feign.sts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JWTSTSGenerator {

    @Value("${sts.client.id}")
    private String clienteId;

    @Value("${sts.client.secret}")
    private String secretId;

    @Value("${sts.url}")
    private String urlSts;

    public String generatorToken() {

        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
        //TODO - Descomente o bloco abaixo quando tiver que integrar a algum STS e apague o return acima
//        final var headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//
//        final var resetTemplate = new RestTemplate();
//
//        var body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s",
//                clienteId,
//                secretId);
//
//        var response = resetTemplate.exchange(
//                urlSts,
//                HttpMethod.POST,
//                new HttpEntity<>(body, headers),
//                String.class
//        );
//
//        return response.getBody();
    }

    public String getClienteId() {
        return clienteId;
    }
}
