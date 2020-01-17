package com.sveikov.step7java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
//@Profile("dev")
public class Component7 implements Comp7Interface{
    List<Float> list=new ArrayList<>();
private double realValue;
    @Override
    public void add(float b) {
        list.add(b);
    }

    @Override
    public List<Float> get() {
        list.stream()
                .forEach(x->log.info(x.toString()));
        return list;
    }

    @Override
    public void setValue(double val) {
        this.realValue=val;
    }

    @Override
    public double getValue() {
        return this.realValue;
    }
}
