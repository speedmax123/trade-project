package com.speedmax.trade.dao;

import com.speedmax.trade.model.TradeUserAccountWithoutVersion;
import org.springframework.data.repository.CrudRepository;

public interface TradeUserAccountWithoutVersionRepository extends CrudRepository<TradeUserAccountWithoutVersion, Long> {
    TradeUserAccountWithoutVersion findOne(Long id);
}
