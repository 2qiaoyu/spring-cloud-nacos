package com.joham.nacos.controller;

import com.joham.nacos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author joham
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/debit")
    public Boolean debit(@RequestParam String userId, @RequestParam BigDecimal money) {
        accountService.debit(userId, money);
        return true;
    }
}
