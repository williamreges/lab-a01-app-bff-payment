package com.example.payment.entrypoint.mapper;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.entrypoint.model.response.TransacaoPixResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoResposeMapper {

    TransacaoResposeMapper INSTANCE = Mappers.getMapper(TransacaoResposeMapper.class);

    TransacaoPixResponse mappterModelToResponse(TransacaoPix transacaoPix);
}
