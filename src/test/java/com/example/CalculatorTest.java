package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest 
{
    @Test
    public void shouldAnswerWithTrue(){
        Calculator testObj=new Calculator();
        assertEquals("3",testObj.calculator_without_check("1+2"));
    }
}
