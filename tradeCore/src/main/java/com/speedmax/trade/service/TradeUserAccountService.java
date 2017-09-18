package com.speedmax.trade.service;


import com.speedmax.trade.model.TradeUserAccount;
import com.speedmax.trade.model.TradeUserAccountWithoutVersion;

public interface TradeUserAccountService {
    TradeUserAccount findOne(Long id);
    void save(TradeUserAccount tradeUser);
    TradeUserAccountWithoutVersion findOneById(Long id);
    void save(TradeUserAccountWithoutVersion tradeUser);
    TradeUserAccount concurrentTest();
    TradeUserAccountWithoutVersion concurrentTestWithoutVersion();
}
