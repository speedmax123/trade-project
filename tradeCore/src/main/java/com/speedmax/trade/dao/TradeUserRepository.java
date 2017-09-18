package com.speedmax.trade.dao;

import com.speedmax.trade.model.TradeUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradeUserRepository extends CrudRepository<TradeUser, Long> {
}
