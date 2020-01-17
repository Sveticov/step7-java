package com.sveikov.step7java;

import java.util.stream.IntStream;

public class ConvertIEEE {
    private int ValueInt;
    private long ValueLong;
    private String ValueString;
    private double ValueFloat;

    public double convertToIEEE(int val) {
//        IntStream.range(0, bytes.length).forEach(
//                x -> {
//                    ValueInt = (ValueInt << 8) | bytes[x];
//                }
//        );
        ValueString = Integer.toBinaryString(val);
        ValueLong = Long.parseLong(ValueString, 2);
        ValueInt = (int) ValueLong;
        ValueFloat = Float.intBitsToFloat(ValueInt);
        return ValueFloat;
    }


    public String convertBool(byte[] bytes) {
        IntStream.range(0, bytes.length).forEach(
                x -> {
                    ValueInt = (ValueInt << 8) | bytes[x];
                }
        );
        ValueString = Integer.toBinaryString(ValueInt);
        return ValueString;
    }
}
