package com.example.payment.application.domain.gateway;

import com.example.payment.application.domain.entity.TransacaoPix;

import java.util.UUID;

public interface TransacaoPixUpdateGateway {
    void update(UUID idTransacao, TransacaoPix transacaoPix);
}
