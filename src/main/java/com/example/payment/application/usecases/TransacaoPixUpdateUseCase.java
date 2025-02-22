package com.example.payment.application.usecases;

import com.example.payment.application.domain.entity.TransacaoPix;

import java.util.UUID;

public interface TransacaoPixUpdateUseCase {

    void update(UUID codigoTrancacao, TransacaoPix transacaoPix);
}
