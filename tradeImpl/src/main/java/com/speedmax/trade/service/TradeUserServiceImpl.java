package com.speedmax.trade.service;

import com.speedmax.trade.dao.TradeUserRepository;
import com.speedmax.trade.model.TradeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tradeUserService")
public class TradeUserServiceImpl implements TradeUserService {

    private TradeUserRepository tradeUserRepo;

    @Autowired
    public TradeUserServiceImpl(TradeUserRepository tradeUserRepository) {
        this.tradeUserRepo = tradeUserRepository;
    }

    @Override
    public TradeUser findOne(Long Id) {
        return tradeUserRepo.findOne(Id);
    }

    @Override
    public List<TradeUser> findAll() {
        return (List<TradeUser>) tradeUserRepo.findAll();
    }

    @Override
    public void save(TradeUser tradeUser) {
        tradeUserRepo.save(tradeUser);
    }
}
