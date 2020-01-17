package com.sveikov.step7java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/app7")
public class Controller7 {

    @Autowired
    Comp7Interface comp7Interface;

    @GetMapping("/p7")
    public Double list() {

        return comp7Interface.getValue();
    }


}
