package com.example.payment.application.usecases.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixConsultationGateway;
import com.example.payment.application.usecases.TransacaoPixConsultationUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransacaoPixConsultationUseCaseImpl implements TransacaoPixConsultationUseCase {
    private static final Logger log = LoggerFactory.getLogger(TransacaoPixConsultationUseCaseImpl.class);
    private final TransacaoPixConsultationGateway consultationGateway;

    public TransacaoPixConsultationUseCaseImpl(TransacaoPixConsultationGateway consultationGateway) {
        this.consultationGateway = consultationGateway;
    }

    @Override
    public TransacaoPix consultation(UUID uuid) {
        log.info("Start Method consultation Transacao Pix: ID: {}", uuid);
        var transacaoPix = consultationGateway.getById(uuid.toString());
        log.info("End Method consultation Transacao Pix: ID {}", uuid);
        return transacaoPix;
    }
}
