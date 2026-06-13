package com.example.payment.entrypoint.model.request;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record TransacaoPixQueryRequest(


        UUID codigoTrancacao,

        UUID codigoPessoa,

        BigDecimal valorTrancacao,

        LocalDateTime dataTrancacao,

        UUID codigoBeneficiario
) {
}
