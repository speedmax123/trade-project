package com.speedmax.trade.service;


import com.speedmax.trade.model.TradeUserAccountWithoutVersion;

public interface TradeUserAccountWithoutVersionService {
    TradeUserAccountWithoutVersion findOne(Long id);
    void save(TradeUserAccountWithoutVersion tradeUser);
    TradeUserAccountWithoutVersion concurrentTest();
}
