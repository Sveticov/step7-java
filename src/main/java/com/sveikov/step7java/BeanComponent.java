package com.sveikov.step7java;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    @Bean
    public ConvertIEEE convertIEEE() {
        return new ConvertIEEE();
    }

//    @Bean
//    public DB db(){
//        return new DB();
//    }
}
