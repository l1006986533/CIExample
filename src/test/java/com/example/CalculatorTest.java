package com.example;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Test;

public class CalculatorTest{
    Calculator testObj=new Calculator();
    @Test
    public void addTest(){
        assertEquals(3,testObj.add(1,2),0.00001);
    }
    @Test
    public void mulTest(){
        assertEquals(10,testObj.mul(2,5),0.00001);
    }
    @Test
    public void subTest(){
        assertEquals(2,testObj.sub(3,1),0.00001);
    }
    @Test
    public void divTest(){
        assertEquals(4,testObj.div(8,2),0.00001);
    }
}
