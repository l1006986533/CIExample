package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{
    Calculator testObj=new Calculator();
    @Test
    public void addTest(){
        assertEquals(3,testObj.add(1,2),0.00001);
    }
    @Test
    public void mulTest(){
        assertEquals(6,testObj.mul(3,2),0.00001);
    }
}
