package com.example.payment.dataprovider.mapper;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.dataprovider.service.model.input.TransacaoPixIn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoPixInMapper {

    TransacaoPixInMapper INSTANCE = Mappers.getMapper(TransacaoPixInMapper.class);

    TransacaoPixIn mapperToIn(TransacaoPix transacaoPix);
}
