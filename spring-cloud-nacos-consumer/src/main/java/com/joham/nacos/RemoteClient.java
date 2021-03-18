package com.joham.nacos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author joham
 */
@FeignClient(name = "spring-cloud-nacos-provider")
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String helloNacos(@RequestParam String name);

    @GetMapping("/debit")
    String debit(@RequestParam String userId, @RequestParam BigDecimal money);
}
