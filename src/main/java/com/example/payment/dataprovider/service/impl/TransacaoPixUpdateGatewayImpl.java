package com.example.payment.dataprovider.service.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixUpdateGateway;
import com.example.payment.dataprovider.mapper.TransacaoPixInMapper;
import com.example.payment.dataprovider.service.HttpTransacaoPixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransacaoPixUpdateGatewayImpl implements TransacaoPixUpdateGateway {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixUpdateGatewayImpl.class);
    private final HttpTransacaoPixService httpTransacaoPixService;

    public TransacaoPixUpdateGatewayImpl(HttpTransacaoPixService httpTransacaoPixService) {
        this.httpTransacaoPixService = httpTransacaoPixService;
    }

    @Override
    public void update(UUID idTransacao, TransacaoPix transacaoPix) {
        log.info("Start Method create Transacao Pix: {}", transacaoPix);
        final var in = TransacaoPixInMapper.INSTANCE.mapperToIn(transacaoPix);
        httpTransacaoPixService.update(idTransacao, in);
        log.info("Start Method create Transacao Pix: {}", transacaoPix);

    }
}
