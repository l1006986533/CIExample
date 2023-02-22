package com.example;

import java.util.*;

public class Calculator {
    public static void main(String[] args){
        String formula = "(1+2)*3*2+6/2";
        String result = new Calculator().calculator_without_check(formula);
        System.out.println(result);
    }
    String calculator_without_check(String formula){
        List<String> splitted=new ArrayList<>();
        String tmp="";
        for(char i:formula.toCharArray()){
            if(i=='.' || isNumber(i)) 
                tmp+=i;
            else{
                if(!tmp.isEmpty()) splitted.add(tmp);
                splitted.add(String.valueOf(i));
                tmp="";
            }
        }
        if(!tmp.isEmpty()) splitted.add(tmp);
        Map<String, Integer> priority = new HashMap<String, Integer>(){{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("(", 0);
            put(")", 0);
        }};
        Stack<String> opstack = new Stack<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<splitted.size();i++){
            if(priority.containsKey(splitted.get(i))){
                String operator=splitted.get(i);
                if(opstack.isEmpty() ||
                   operator.equals("(") ||
                   (opstack.peek().equals("(") && operator.equals(")")) ||
                   priority.get(opstack.peek())<priority.get(operator)
                ){
                    opstack.add(operator);
                }else if(operator.equals(")")){
                    while(!opstack.peek().equals("(")){
                        list.add(opstack.pop());
                    }
                    opstack.pop();
                }else{
                    while(!opstack.isEmpty() && priority.get(opstack.peek())>=priority.get(operator)){
                        list.add(opstack.pop());
                    }
                    opstack.push(operator);
                }
            }else{
                list.add(splitted.get(i));
            }
        }
        while (!opstack.isEmpty()){
            list.add(opstack.pop());
        }
        Stack<String> numstack = new Stack<String>();
        for (String str : list){
            if (isNumber(str)){
                numstack.push(str);
            }else {
                double num1 = Double.parseDouble(numstack.pop());
                double num2 = Double.parseDouble(numstack.pop());
                double result = caclulateRes(num2, num1, str);
                numstack.push(doubleTrans(result));
            }
        }
        return numstack.pop();
    }

    boolean isNumber(char c){
        return c>=48 && c<=57;
    }
    boolean isNumber(String s){
        for(char c:s.toCharArray())
            if(c!='.' && !isNumber(c))
                return false;
        return true;
    }
    String doubleTrans(double d){
        if(Math.round(d)-d==0){
            return String.valueOf((long)d);
        }
        return String.valueOf(d);
    }
    double caclulateRes(double num1, double num2, String experssion){
        double result;
        switch (experssion){
            case "+" :
                result = add(num1, num2);
                break;
            case "-" :
                result = sub(num1, num2);
                break;
            case "*" :
                result = mul(num1, num2);
                break;
            case "/" :
                result = div(num1, num2);
                break;
            default:
                throw new RuntimeException("Unexpected experssion: " + experssion);
        }
        return result;
    }

    double add(double a,double b){
        return a+b;
    }
    double sub(double a,double b){
        return a-b;
    }
    double mul(double a,double b){
        return a*b;
    }
    double div(double a,double b){
        return a/b;
    }
}
