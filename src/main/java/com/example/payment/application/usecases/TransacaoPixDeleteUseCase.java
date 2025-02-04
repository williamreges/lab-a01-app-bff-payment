package com.example.payment.application.usecases;

import java.util.UUID;

public interface TransacaoPixDeleteUseCase {

    void delete(UUID codigoTrancacao);
}
