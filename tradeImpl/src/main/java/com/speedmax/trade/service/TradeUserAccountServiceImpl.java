package com.speedmax.trade.service;

import com.google.common.collect.Lists;
import com.speedmax.trade.dao.TradeUserAccountRepository;
import com.speedmax.trade.dao.TradeUserAccountWithoutVersionRepository;
import com.speedmax.trade.model.TradeUserAccount;
import com.speedmax.trade.model.TradeUserAccountWithoutVersion;
import org.hibernate.StaleStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service("tradeUserAccountService")
public class TradeUserAccountServiceImpl implements TradeUserAccountService {

    private final static Logger logger = LoggerFactory.getLogger(TradeUserAccountServiceImpl.class);

    private TradeUserAccountRepository tradeUserAccountRepository;
    private TradeUserAccountWithoutVersionRepository tradeUserAccountWithoutVersionRepository;
    private AsyncTransactionService asyncTransactionService;
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    public TradeUserAccountServiceImpl(TradeUserAccountRepository tradeUserAccountRepository,
                                       TradeUserAccountWithoutVersionRepository tradeUserAccountWithoutVersionRepository,
                                       AsyncTransactionService asyncTransactionService,
                                       ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.tradeUserAccountRepository = tradeUserAccountRepository;
        this.tradeUserAccountWithoutVersionRepository = tradeUserAccountWithoutVersionRepository;
        this.asyncTransactionService = asyncTransactionService;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @Override
    public TradeUserAccount findOne(Long id) {
        return this.tradeUserAccountRepository.findOne(id);
    }

    @Override
    public void save(TradeUserAccount tradeUserAccount) {
        this.tradeUserAccountRepository.save(tradeUserAccount);
    }

    @Override
    public TradeUserAccountWithoutVersion findOneById(Long id) {
        return this.tradeUserAccountWithoutVersionRepository.findOne(id);
    }

    @Override
    public void save(TradeUserAccountWithoutVersion tradeUser) {
        this.tradeUserAccountWithoutVersionRepository.save(tradeUser);
    }

    @Override
    public TradeUserAccount concurrentTest() {

        List<Callable<Void>> tasks = Lists.newArrayList();
        for (int i = 0; i < 1; i++) {
            tasks.add(new SimpleAddTransaction());
        }
        tasks.forEach(task -> this.threadPoolTaskExecutor.submit(task));

        // wait for all task end
        for (;;) {
            int count = this.threadPoolTaskExecutor.getActiveCount();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 0) {
                break;
            }
        }
        return null;
    }

    @Override
    public TradeUserAccountWithoutVersion concurrentTestWithoutVersion() {
        List<Callable<Void>> tasks = Lists.newArrayList();
        for (int i = 0; i < 1; i++) {
            tasks.add(new SimpleAddWithoutVersionTransaction());
        }
        tasks.forEach(task -> this.threadPoolTaskExecutor.submit(task));

        // wait for all task end
        for (;;) {
            int count = this.threadPoolTaskExecutor.getActiveCount();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 0) {
                break;
            }
        }

        return this.findOneById(1L);
    }

    private class SimpleAddTransaction implements Callable<Void> {
        @Override
        public Void call() {
            asyncTransactionService.simpleTransaction();
            return null;
        }
    }

    private class SimpleAddWithoutVersionTransaction implements Callable<Void> {
        @Override
        public Void call() {
            asyncTransactionService.simpleTransactionWithoutVersion();
            return null;
        }
    }
}
