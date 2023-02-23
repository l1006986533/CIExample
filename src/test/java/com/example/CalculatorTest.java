package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{
    Calculator testObj=new Calculator();
    @Test
    public void addTest(){
        assertEquals("3",testObj.calculator_without_check("1+2"));
    }
}
