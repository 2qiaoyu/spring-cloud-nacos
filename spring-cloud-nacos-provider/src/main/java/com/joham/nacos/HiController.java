package com.joham.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joham
 */
@RestController
public class HiController {

    @Value("${provider}")
    String provider;

    @GetMapping("helloNacos")
    public String helloNacos(@RequestParam String name) {
        return "hi " + name + ",i am " + provider;
    }
}
