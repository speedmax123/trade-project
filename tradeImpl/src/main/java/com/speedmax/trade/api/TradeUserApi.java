package com.speedmax.trade.api;

import com.speedmax.trade.model.TradeUser;
import com.speedmax.trade.service.TradeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trade/user")
public class TradeUserApi {

    private TradeUserService tradeUserService;

    @Autowired
    public TradeUserApi(TradeUserService tradeUserService) {
        this.tradeUserService = tradeUserService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public TradeUser getTradeUserById(@PathVariable Long id) {
        return tradeUserService.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public List<TradeUser> getAllTradeUser() {
        return tradeUserService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void createTradeUser(TradeUser tradeUser) {
        tradeUserService.save(tradeUser);
    }
}
