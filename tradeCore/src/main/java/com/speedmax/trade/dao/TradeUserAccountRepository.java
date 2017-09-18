package com.speedmax.trade.dao;

import com.speedmax.trade.model.TradeUserAccount;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;

public interface TradeUserAccountRepository extends CrudRepository<TradeUserAccount, Long> {
    TradeUserAccount findOne(Long id);
}
