package com.example.payment.entrypoint.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoPixRequest(
        @JsonProperty("codigoPessoa")
        @NotNull(message = "codigoPessoa can not null")
        String codigoPessoa,

        @NotNull(message = "valorTrancacao can not null")
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

