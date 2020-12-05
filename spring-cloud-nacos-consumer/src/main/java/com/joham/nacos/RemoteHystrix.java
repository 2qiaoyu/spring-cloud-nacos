package com.joham.nacos;

import org.springframework.stereotype.Component;

@Component
public class RemoteHystrix implements RemoteClient {

    @Override
    public String helloNacos(String name) {
        return "请求超时了";
    }
}
