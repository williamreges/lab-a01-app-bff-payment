package com.example.payment.dataprovider.service;

import com.example.payment.dataprovider.service.model.input.TransacaoPixIn;
import com.example.payment.dataprovider.service.model.output.TransacaoPixOut;
import com.example.payment.infraestructure.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@FeignClient(name = "transacaorepository", url = "http://localhost:8000", configuration = FeignConfig.class)
public interface HttpTransacaoPixService {

    @GetMapping(
            value = "transacao-pix/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    TransacaoPixOut getById(
            @PathVariable("id") String id);

    @PostMapping(
            value = "transacao-pix",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    String save(
            @RequestBody TransacaoPixIn transacaoPixIn);

    @PutMapping(
            value = "transacao-pix/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void update(
            @PathVariable("id") UUID id,
            @RequestBody TransacaoPixIn transacaoPixIn);

    @DeleteMapping(
            value = "transacao-pix/{id}")
    void delete(
            @PathVariable("id") UUID id);

}
