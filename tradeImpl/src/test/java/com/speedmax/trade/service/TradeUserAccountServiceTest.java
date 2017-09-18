package com.speedmax.trade.service;

import com.speedmax.trade.BaseTest;
import com.speedmax.trade.model.TradeUserAccount;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.*;


@Transactional
public class TradeUserAccountServiceTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(TradeUserAccountServiceTest.class);

    @Autowired private TradeUserAccountService tradeUserAccountService;
    @Autowired private AsyncTransactionService asyncTransactionService;
    @Autowired ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private List<Callable<Void>> tasks;
    private TradeUserAccount tradeUserAccount;


    @Before
    public void setup() {
        this.tasks = Lists.newArrayList();
        for(int i = 0; i < 16; i++) {
            this.tasks.add(new SimpleAddTransaction());
        }
        TradeUserAccount tradeUserAccount = TradeUserAccount
                .builder()
                .id(1L)
                .firstName("Speed")
                .lastName("xu")
                .amountAvaliable(1000.00)
                .build();
        this.tradeUserAccountService.save(tradeUserAccount);
    }

    @Test
    public void concurrentUpdateDBTest() throws InterruptedException, ExecutionException {
        this.tasks.forEach(task -> this.threadPoolTaskExecutor.submit(task));
        TradeUserAccount tradeUserAccount = this.tradeUserAccountService.findOne(1L);
        logger.info(String.valueOf(tradeUserAccount.getAmountAvaliable() == 1016L));
    }

    private class SimpleAddTransaction implements Callable<Void> {
        @Override
        public Void call() {
            asyncTransactionService.simpleTransaction();
            return null;
        }
    }
}
