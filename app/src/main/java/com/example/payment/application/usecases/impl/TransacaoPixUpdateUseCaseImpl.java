package com.example.payment.application.usecases.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixUpdateGateway;
import com.example.payment.application.usecases.TransacaoPixUpdateUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransacaoPixUpdateUseCaseImpl implements TransacaoPixUpdateUseCase {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixUpdateUseCaseImpl.class);
    private final TransacaoPixUpdateGateway updateGateway;

    public TransacaoPixUpdateUseCaseImpl(TransacaoPixUpdateGateway updateGateway) {
        this.updateGateway = updateGateway;
    }

    @Override
    public void update(UUID codigoTrancacao, TransacaoPix transacaoPix) {
        log.info("Start Method Update Transacao Pix: {}", transacaoPix);
        updateGateway.update(codigoTrancacao, transacaoPix);
        log.info("End Method Update Transacao Pix: {}", transacaoPix);
    }
}
