package com.example.payment.dataprovider.service.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixCreateGateway;
import com.example.payment.dataprovider.mapper.TransacaoPixInMapper;
import com.example.payment.dataprovider.service.HttpTransacaoPixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransacaoPixCreateGatewayImpl implements TransacaoPixCreateGateway {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixCreateGatewayImpl.class);

    private final HttpTransacaoPixService httpTransacaoPixService;

    public TransacaoPixCreateGatewayImpl(HttpTransacaoPixService httpTransacaoPixService) {
        this.httpTransacaoPixService = httpTransacaoPixService;
    }

    @Override
    public String create(TransacaoPix transacaoPix) {
        log.info("Start Method create Transacao Pix: {}", transacaoPix);
        final var in = TransacaoPixInMapper.INSTANCE.mapperToIn(transacaoPix);
        var idNovaTransacao = httpTransacaoPixService.save(in);
        log.info("End Method create Transacao Pix: Id da Transação Gerado {}", idNovaTransacao);
        return idNovaTransacao;
    }
}
