package com.example.payment.application.usecases.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixCreateGateway;
import com.example.payment.application.usecases.TransacaoPixSaveUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransacaoPixSaveUseCaseImpl implements TransacaoPixSaveUseCase {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixSaveUseCaseImpl.class);
    private final TransacaoPixCreateGateway transacaoPixCreateGateway;

    public TransacaoPixSaveUseCaseImpl(TransacaoPixCreateGateway transacaoPixCreateGateway) {
        this.transacaoPixCreateGateway = transacaoPixCreateGateway;
    }

    @Override
    public String save(TransacaoPix transacaoPix) {
        log.info("Start Method Save Transacao Pix: {}", transacaoPix);
        var idNovaTransacao = transacaoPixCreateGateway.create(transacaoPix);
        log.info("End Method Save Transacao Pix: {}", transacaoPix);
        return idNovaTransacao;
    }
}
