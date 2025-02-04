package com.example.payment.application.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoPix(
        String codigoTrancacao,
        String codigoPessoa,
        BigDecimal valorTrancacao,
        LocalDateTime dataTrancacao,
        String codigoBeneficiario,
        String mensagemTransacao
) {
}
