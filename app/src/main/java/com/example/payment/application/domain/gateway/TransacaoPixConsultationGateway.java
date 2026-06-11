package com.example.payment.application.domain.gateway;

import com.example.payment.application.domain.entity.TransacaoPix;


public interface TransacaoPixConsultationGateway {
    TransacaoPix getById(String id);
}
