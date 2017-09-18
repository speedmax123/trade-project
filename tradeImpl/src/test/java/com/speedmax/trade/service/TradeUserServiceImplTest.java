package com.speedmax.trade.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.speedmax.trade.BaseTest;
import com.speedmax.trade.model.TradeUser;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TradeUserServiceImplTest extends BaseTest{

    private static final Logger LOG = LoggerFactory.getLogger(TradeUserServiceImpl.class);

    @Autowired
    private TradeUserService tradeUserService;

    @Test
    public void findOne() throws Exception {
        TradeUser tradeUsers = tradeUserService.findOne(1L);
        assertNull(tradeUsers);
    }

    @Test
    public void findAll() throws Exception {
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
        tradeUserService.save(tradeUser);
        List<TradeUser> tradeUsers = tradeUserService.findAll();
        assertEquals(1, tradeUsers.size());
    }

    @Test
    public void save() throws Exception {
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
        tradeUserService.save(tradeUser);
        List<TradeUser> tradeUsers = tradeUserService.findAll();
        TradeUser tradeUser1 = tradeUsers.get(0);
        assertEquals(tradeUser, tradeUser1);
    }

    @Test
    public void serializeTest() throws JsonProcessingException {
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
        ObjectMapper objectMapper = new ObjectMapper();
        LOG.info(objectMapper.writeValueAsString(tradeUser));
    }

}