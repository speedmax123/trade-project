package com.speedmax.trade.dao;

import com.speedmax.trade.BaseTest;
import com.speedmax.trade.model.TradeUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TradeUserRepositoryTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(TradeUserRepository.class);


    @Autowired
    private TradeUserRepository tradeUserRepository;

    @Test
    public void findTradeUserByIdTest() {
        TradeUser tradeUser = tradeUserRepository.findOne(1L);
    }

    @Test
    public void insertOneTest() {
        TradeUser tradeUser = TradeUser
                .builder()
                .userType(1000000L)
                .agentId(1000000L)
                .authStep(0L)
                .autoPayment(0L)
                .cashStatus(0L)
                .content("some content")
                .continuousDays("1")
                .controlSendTimes(10000000L)
                .createTime(new Date())
                .creditLimit(1000L)
                .xMin(1000L)
                .xMax(1001L)
                .password("abdcd1234")
                .dealpwd("abcd1234")
                .email("xjttt1991@gmail.com")
                .feeStatus(1L)
                .headImg("xxxxxxxx")
                .loginErrorCount(5L)
                .build();
        tradeUserRepository.save(tradeUser);
        tradeUserRepository.findAll().forEach(tu -> {
            LOG.info(tu.toString());
        });
    }
}
