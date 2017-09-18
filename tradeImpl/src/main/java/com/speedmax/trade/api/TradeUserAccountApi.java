package com.speedmax.trade.api;

import com.speedmax.trade.model.TradeUserAccount;
import com.speedmax.trade.model.TradeUserAccountWithoutVersion;
import com.speedmax.trade.service.TradeUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/api/v1/trade/user/account")
public class TradeUserAccountApi {

    private final static Logger logger = LoggerFactory.getLogger(TradeUserAccountApi.class);
    private TradeUserAccountService tradeUserAccountService;

    @Autowired
    public TradeUserAccountApi(TradeUserAccountService tradeUserAccountService) {
        this.tradeUserAccountService = tradeUserAccountService;
    }

    @RequestMapping(value = "/concurrentTestReset", method = RequestMethod.GET, produces = "application/json")
    public Object reset(@RequestParam(value = "version", defaultValue = "true") boolean version) {
        if(version) {
            TradeUserAccount tradeUserAccount = this.tradeUserAccountService.findOne(1L);
            tradeUserAccount.setAmountAvaliable(1000.00);
            this.tradeUserAccountService.save(tradeUserAccount);
            return this.tradeUserAccountService.findOne(1L);
        } else {
            TradeUserAccountWithoutVersion tradeUserAccountWithoutVersion = this.tradeUserAccountService.findOneById(1L);
            tradeUserAccountWithoutVersion.setAmountAvaliable(1000.00);
            this.tradeUserAccountService.save(tradeUserAccountWithoutVersion);
            return this.tradeUserAccountService.findOneById(1L);
        }
    }

    @RequestMapping(value = "/concurrentTest", method = RequestMethod.GET, produces = "application/json")
    public TradeUserAccount simpleConcurrentTest() {
        return this.tradeUserAccountService.concurrentTest();
    }

    @RequestMapping(value = "/concurrentTestWithoutVersion", method = RequestMethod.GET, produces = "application/json")
    public TradeUserAccountWithoutVersion simpleConcurrentTest1() {
        return this.tradeUserAccountService.concurrentTestWithoutVersion();
    }
}
