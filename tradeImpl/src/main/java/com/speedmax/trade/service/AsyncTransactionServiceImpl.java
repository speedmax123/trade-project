package com.speedmax.trade.service;

import com.speedmax.trade.dao.TradeUserAccountRepository;
import com.speedmax.trade.dao.TradeUserAccountWithoutVersionRepository;
import com.speedmax.trade.model.TradeUserAccount;
import com.speedmax.trade.model.TradeUserAccountWithoutVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

@Service("asyncTransactionService")
public class AsyncTransactionServiceImpl implements AsyncTransactionService {

    private final static Logger logger = LoggerFactory.getLogger(AsyncTransactionServiceImpl.class);

    private TradeUserAccountRepository tradeUserAccountRepository;
    private TradeUserAccountWithoutVersionRepository tradeUserAccountWithoutVersionRepository;

    @Autowired
    public AsyncTransactionServiceImpl(TradeUserAccountRepository tradeUserAccountRepository,
                                       TradeUserAccountWithoutVersionRepository tradeUserAccountWithoutVersionRepository) {
        this.tradeUserAccountRepository = tradeUserAccountRepository;
        this.tradeUserAccountWithoutVersionRepository = tradeUserAccountWithoutVersionRepository;
    }

    @Override
    public void simpleTransaction() {
        TradeUserAccount tradeUserAccount = this.tradeUserAccountRepository.findOne(1L);
        logger.info("user account => \t" + tradeUserAccount.getAmountAvaliable());
        tradeUserAccount.setAmountAvaliable(tradeUserAccount.getAmountAvaliable() + 1);
        tradeUserAccount = this.tradeUserAccountRepository.save(tradeUserAccount);
        logger.info("user account => \t" + tradeUserAccount.getAmountAvaliable());
    }

    @Override
    public synchronized void simpleTransactionWithoutVersion() {
        TradeUserAccountWithoutVersion tradeUserAccountWithoutVersion = this.tradeUserAccountWithoutVersionRepository.findOne(1L);
        logger.info("user account without version => \t" + tradeUserAccountWithoutVersion.getAmountAvaliable());
        tradeUserAccountWithoutVersion.setAmountAvaliable(tradeUserAccountWithoutVersion.getAmountAvaliable() + 1);
        tradeUserAccountWithoutVersion = this.tradeUserAccountWithoutVersionRepository.save(tradeUserAccountWithoutVersion);
        logger.info("user account without version => \t" + tradeUserAccountWithoutVersion.getAmountAvaliable());
    }

    @Recover
    public void recover(ObjectOptimisticLockingFailureException e) {
        System.err.println("I am so sorry!");
        throw new RuntimeException("I am so sorry!");
    }
}
