package com.example;

import java.util.Scanner;

public class Calculator 
{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter formula");
        String formula = myScanner.nextLine();
        String result = new Calculator().calculator(formula);
        System.out.println(result);
        myScanner.close();
    }
    String calculator(String formula){
        if(formula.contains("+")){
            int l=formula.indexOf("+");
            int a = Integer.parseInt(formula.substring(0, l));
            int b = Integer.parseInt(formula.substring(l));
            int result=plus(a,b);
            return String.valueOf(result);
        }else{
            return "Todo";
        }
    }
    int plus(int a,int b){
        return 0;
    }
}
