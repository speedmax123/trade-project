package com.speedmax.trade.service;

import com.speedmax.trade.model.TradeUser;

import java.util.List;

public interface TradeUserService {
    TradeUser findOne(Long Id);
    List<TradeUser> findAll();
    void save(TradeUser tradeUser);
}
