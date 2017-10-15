package com.speedmax.trade.service;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Retryable;

public interface AsyncTransactionService {

    @Retryable(maxAttempts = 3, value = { ObjectOptimisticLockingFailureException.class })
    void simpleTransaction();

    void simpleTransactionWithoutVersion();
}
