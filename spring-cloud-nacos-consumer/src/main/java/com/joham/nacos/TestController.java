package com.joham.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author joham
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${provider}")
    String provider;

    @Value("${test}")
    String test;

    @Autowired
    private RemoteClient remoteClient;


    @GetMapping("test1")
    public String hi(String name) {
        return remoteClient.helloNacos(name);
//        return "hi" + name + " ,i am " + provider + "he is " + test;
    }

    @GetMapping("test2")
    public String test2(String userId, BigDecimal money) {
        return remoteClient.debit(userId, money);
//        return "hi" + name + " ,i am " + provider + "he is " + test;
    }
}
