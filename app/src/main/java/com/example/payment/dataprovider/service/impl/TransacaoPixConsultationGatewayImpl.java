package com.example.payment.dataprovider.service.impl;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.application.domain.gateway.TransacaoPixConsultationGateway;
import com.example.payment.dataprovider.mapper.TransacaoPixOutMapper;
import com.example.payment.dataprovider.service.HttpTransacaoPixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransacaoPixConsultationGatewayImpl implements TransacaoPixConsultationGateway {

    private static final Logger log = LoggerFactory.getLogger(TransacaoPixConsultationGatewayImpl.class);
    private final HttpTransacaoPixService httpTransacaoPixService;

    public TransacaoPixConsultationGatewayImpl(HttpTransacaoPixService httpTransacaoPixService) {
        this.httpTransacaoPixService = httpTransacaoPixService;
    }

    @Override
    public TransacaoPix getById(String id) {
        log.info("Starter Method getById");
        var transacaoPixOut = httpTransacaoPixService.getById(id);
        log.info("Response obtido: {}", transacaoPixOut);
        return Optional.ofNullable(transacaoPixOut)
                .map(TransacaoPixOutMapper.INSTANCE::mapperToModel)
                .orElseThrow();

    }
}
