package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegrationTest {
    Calculator testObj=new Calculator();

    @Test
    public void calculatorAddTest()
    {
        assertEquals(testObj.calculator("1+2+3+4+(4+2)+0"),"16");
    }

    @Test
    public void calculatorSubTest()
    {
        assertEquals(testObj.calculator("1-2-3-4-(4-2)-0"),"-10");
    }

    @Test
    public void calculatorMulTest()
    {
        assertEquals(testObj.calculator("1*2*3*4*5*(1*1)"),"120");
    }

    @Test
    public void calculatorDivTest()
    {
        assertEquals(testObj.calculator("1/2/3/4/5/6"),"0.001388888888888889");
    }
    @Test
    public void calculatorElementaryArithmeticTest()
    {
        assertEquals(testObj.calculator("(1+2)*3+6/2"),"12");
        assertEquals(testObj.calculator("2/3+3*2-10"),"-3.333333333333333");
        assertEquals(testObj.calculator("4*4-2/5+(5-1)*2"),"23.6");
        assertEquals(testObj.calculator("0*9+(0-100)*(0/1)"),"0");
    }
}
