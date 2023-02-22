package com.example;

import java.util.*;

public class Calculator 
{
    public static void main(String[] args){
        String formula = "(1+2)*3*2+6/2";
        String result = new Calculator().calculator(formula);
        System.out.println(result);
    }
    String calculator(String formula){
        //1.分割 
        List<String> splitted=new ArrayList<>();
        String tmp="";
        for(char i:formula.toCharArray()){
            if(i=='.' || isNumber(i)) 
                tmp+=i;
            else{
                if(!tmp.isBlank()) splitted.add(tmp);
                splitted.add(String.valueOf(i));
                tmp="";
            }
        }
        if(!tmp.isBlank()) splitted.add(tmp);
        //2.转后缀表达式
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
                //运算符号
                String operator=splitted.get(i);
                //1.栈空
                //2.左括号进栈
                //3.栈顶是左括号，输入右括号时，进栈
                //4.栈顶是加减，当前元素是乘除
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
                    opstack.pop(); //弹出左括号
                }else{
                    while(!opstack.isEmpty() && priority.get(opstack.peek())>=priority.get(operator)){
                        list.add(opstack.pop()); //弹出所有乘除
                    }
                    opstack.push(operator);
                }
            }else{
                //数字
                list.add(splitted.get(i));
            }
        }
        while (!opstack.isEmpty()){
            list.add(opstack.pop());
        }
        //3.计算结果
        Stack<String> numstack = new Stack<String>();//用于保存数字
        for (String str : list){
            if (isNumber(str)){
                numstack.push(str);
            }else {
                double num1 = Double.parseDouble(numstack.pop());
                double num2 = Double.parseDouble(numstack.pop());
                double result = caclulateRes(num1, num2, str);
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
                result = num1 + num2;
                break;
            case "-" :
                result = num2 - num1;
                break;
            case "*" :
                result = num2 * num1;
                break;
            case "/" :
                result = num2 / num1;
                break;
            default:
                throw new RuntimeException("Unexpected experssion: " + experssion);
        }
        return result;
    }

    double add(double a,double b){
        return 0;
    }
    double sub(double a,double b){
        return 0;
    }
    double mul(double a,double b){
        return 0;
    }
    double div(double a,double b){
        return 0;
    }
}
