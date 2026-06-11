package com.example.payment.dataprovider.service.model.input;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoPixIn(
        @JsonProperty("codigoTrancacao")
        String codigoTrancacao,
        @JsonProperty("codigoPessoa")
        String codigoPessoa,
        @JsonProperty("valorTrancacao")
        BigDecimal valorTrancacao,
        @JsonProperty("dataTrancacao")
        LocalDateTime dataTrancacao,
        @JsonProperty("codigoBeneficiario")
        String codigoBeneficiario,
        @JsonProperty("mensagemTransacao")
        String mensagemTransacao

) {
}
