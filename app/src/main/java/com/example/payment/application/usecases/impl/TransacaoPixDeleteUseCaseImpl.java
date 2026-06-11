package com.example.payment.application.usecases.impl;

import com.example.payment.application.domain.gateway.TransacaoPixDeleteGateway;
import com.example.payment.application.usecases.TransacaoPixDeleteUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransacaoPixDeleteUseCaseImpl implements TransacaoPixDeleteUseCase {


    private static final Logger log = LoggerFactory.getLogger(TransacaoPixDeleteUseCaseImpl.class);
    private final TransacaoPixDeleteGateway deleteGateway;

    public TransacaoPixDeleteUseCaseImpl(TransacaoPixDeleteGateway deleteGateway) {
        this.deleteGateway = deleteGateway;
    }

    @Override
    public void delete(UUID codigoTrancacao) {
        log.info("Start Method Delete Transacao Pix: {}", codigoTrancacao);
        deleteGateway.delette(codigoTrancacao);
        log.info("End Method Delete Transacao Pix: {}", codigoTrancacao);
    }

}
