package com.joham.nacos;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joham
 */
@RestController
@RefreshScope
public class HiController {

    @Value("${provider}")
    String provider;

    @GetMapping("helloNacos")
    public String helloNacos(@RequestParam String name, String slow) throws InterruptedException {
        if ("true".equals(slow)) {
            Thread.sleep(100);
        }
        return "hi " + name + ",i am " + provider;
    }

    @GetMapping("test/sentinel")
    @SentinelResource(value = "sentinel", blockHandler = "exceptionHandler", fallback = "sentinelFallback")
    public String sentinel(@RequestParam String name) {
        return "hi sentinel " + name;
    }

    /**
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     *
     * @return
     */
    public String sentinelFallback(String name) {
        return "joham Blocked by Sentinel: " + name;
    }

    /**
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     *
     * @return
     */
    public String exceptionHandler(String name) {
        return "joham Oops, error occurred at " + name;
    }
}
