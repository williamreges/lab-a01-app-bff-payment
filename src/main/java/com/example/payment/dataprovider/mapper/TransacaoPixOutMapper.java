package com.example.payment.dataprovider.mapper;

import com.example.payment.application.domain.entity.TransacaoPix;
import com.example.payment.dataprovider.service.model.output.TransacaoPixOut;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransacaoPixOutMapper {

    TransacaoPixOutMapper INSTANCE = Mappers.getMapper(TransacaoPixOutMapper.class);

    TransacaoPix mapperToModel(TransacaoPixOut transacaoPixOut);
}
