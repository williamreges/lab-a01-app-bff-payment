package com.example.payment.entrypoint.mapper;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.entrypoint.model.request.TransacaoPixRequest;
import com.example.payment.entrypoint.model.request.TransacaoPixUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoPixRequestMapper {

    TransacaoPixRequestMapper INSTANCE = Mappers.getMapper(TransacaoPixRequestMapper.class);

    TransacaoPix mapperToDomain(TransacaoPixRequest request);

    TransacaoPix mapperToDomainUpdate(TransacaoPixUpdateRequest request);
}
