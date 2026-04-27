package com.flix.app.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class PingAPI {



    @GetMapping
    public String ping() {
        return "OK";
    }
}
