package com.example.payment.entrypoint.controller;

import com.example.payment.application.usecases.TransacaoPixConsultationUseCase;
import com.example.payment.application.usecases.TransacaoPixDeleteUseCase;
import com.example.payment.application.usecases.TransacaoPixSaveUseCase;
import com.example.payment.application.usecases.TransacaoPixUpdateUseCase;
import com.example.payment.entrypoint.mapper.TransacaoPixRequestMapper;
import com.example.payment.entrypoint.mapper.TransacaoResposeMapper;
import com.example.payment.entrypoint.model.request.TransacaoPixRequest;
import com.example.payment.entrypoint.model.request.TransacaoPixUpdateRequest;
import com.example.payment.entrypoint.model.response.TransacaoPixResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/transacao-pix")
public class TransacaoPixController {

    private static final Logger log = LogManager.getLogger(TransacaoPixController.class);
    private final TransacaoPixSaveUseCase transacaoPixSaveUseCase;
    private final TransacaoPixUpdateUseCase transacaoPixUpdateUseCase;
    private final TransacaoPixDeleteUseCase transacaoPixDeleteUseCase;
    private final TransacaoPixConsultationUseCase transacaoPixConsultationUseCase;

    public TransacaoPixController(TransacaoPixSaveUseCase transacaoPixSaveUseCase, TransacaoPixUpdateUseCase transacaoPixUpdateUseCase, TransacaoPixDeleteUseCase transacaoPixDeleteUseCase, TransacaoPixConsultationUseCase transacaoPixConsultationUseCase) {
        this.transacaoPixSaveUseCase = transacaoPixSaveUseCase;
        this.transacaoPixUpdateUseCase = transacaoPixUpdateUseCase;
        this.transacaoPixDeleteUseCase = transacaoPixDeleteUseCase;
        this.transacaoPixConsultationUseCase = transacaoPixConsultationUseCase;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransacaoPixResponse getById(@Valid @NotNull @PathVariable("id") String id) {
        log.info("Start getById {}", id);
        var transacaoPix = transacaoPixConsultationUseCase.consultation(UUID.fromString(id));
        return Optional.ofNullable(transacaoPix)
                .map(TransacaoResposeMapper.INSTANCE::mappterModelToResponse)
                .orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody TransacaoPixRequest request) {
        log.info("Start save {}", request);
        var transacaoPix = TransacaoPixRequestMapper.INSTANCE.mapperToDomain(request);
        return transacaoPixSaveUseCase.save(transacaoPix);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        log.info("Start delete {}", id);
        transacaoPixDeleteUseCase.delete(UUID.fromString(id));
        log.info("End delete {}", id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody TransacaoPixUpdateRequest request) {
        log.info("Start update {}", id);
        var transacaoPix = TransacaoPixRequestMapper.INSTANCE.mapperToDomainUpdate(request);
        transacaoPixUpdateUseCase.update(UUID.fromString(id), transacaoPix);
    }

}
