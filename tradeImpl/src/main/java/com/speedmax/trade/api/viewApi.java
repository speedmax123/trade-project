package com.speedmax.trade.api;

import com.speedmax.trade.model.TradeUserAccount;
import com.speedmax.trade.model.TradeUserAccountWithoutVersion;
import com.speedmax.trade.service.TradeUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/v1")
public class viewApi {

    private TradeUserAccountService tradeUserAccountService;

    @Autowired
    public viewApi(TradeUserAccountService tradeUserAccountService) {
        this.tradeUserAccountService = tradeUserAccountService;
    }

    @RequestMapping(value = "/tradeAccount", method = RequestMethod.GET, produces = "text/html")
    public String createTradeUser(Model model) {
        TradeUserAccount tua = this.tradeUserAccountService.findOne(1L);
        TradeUserAccountWithoutVersion tuawv = this.tradeUserAccountService.findOneById(1L);
        model.addAttribute("tradeAccount", tua);
        model.addAttribute("tradeAccountNoVersion", tuawv);
        return "index.tpl";
    }
}
