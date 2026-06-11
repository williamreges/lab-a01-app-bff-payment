package com.example.payment.dataprovider.service.impl;

import com.example.payment.application.domain.gateway.TransacaoPixDeleteGateway;
import com.example.payment.dataprovider.service.HttpTransacaoPixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransacaoPixDeleteGatewayImpl implements TransacaoPixDeleteGateway {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixDeleteGatewayImpl.class);
    private final HttpTransacaoPixService httpTransacaoPixService;

    public TransacaoPixDeleteGatewayImpl(HttpTransacaoPixService httpTransacaoPixService) {
        this.httpTransacaoPixService = httpTransacaoPixService;
    }

    @Override
    public void delette(UUID codigoTrancacao) {
        log.info("Start Method Delete Transacao Pix: {}", codigoTrancacao);
        httpTransacaoPixService.delete(codigoTrancacao);
        log.info("End Method Delete Transacao Pix: {}", codigoTrancacao);
    }
}
