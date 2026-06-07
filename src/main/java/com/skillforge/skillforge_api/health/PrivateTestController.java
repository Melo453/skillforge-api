package com.skillforge.skillforge_api.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/private")
public class PrivateTestController {

    @GetMapping("/test")
    public String sayRunning(){
        return "Private endpoint works";
    }
}
