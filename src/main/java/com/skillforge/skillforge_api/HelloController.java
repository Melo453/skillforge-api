package com.skillforge.skillforge_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/v1")
    public String sayRunning(){
        return "SkillForge API is running";
    }
}
