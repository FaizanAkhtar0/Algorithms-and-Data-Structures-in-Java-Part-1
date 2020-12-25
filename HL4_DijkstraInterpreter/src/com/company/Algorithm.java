package com.company;

import java.util.Stack;

public class Algorithm {

    private Stack<String> operationStack;
    private Stack<Double> ValueStack;

    public Algorithm(){
        this.operationStack = new Stack<>();
        this.ValueStack = new Stack<>();

    }

    public void interpretExpression(String expression){

        String[] expressionArray = expression.split(" ");

        for (String s: expressionArray){
            if (s.equals("(")){
                System.out.print("( ");
            }else if(s.equals("+")){
                System.out.print(" + ");
                this.operationStack.push(s);
            }else if(s.equals("*")){
                System.out.print(" * ");
                this.operationStack.push(s);
            }else if(s.equals("/")){
                System.out.print(" / ");
                this.operationStack.push(s);
            }
            else if (s.equals(")")){
                System.out.print(" )");
                 String operation = this.operationStack.pop();

                 if (operation.equals("+")){
                     this.ValueStack.push(this.ValueStack.pop() + this.ValueStack.pop());
//                     System.out.print(" = " + this.ValueStack.peek());
                 }else if (operation.equals("/")){
                     this.ValueStack.push(this.ValueStack.pop() / this.ValueStack.pop());
                 }
                 else {
                     this.ValueStack.push(this.ValueStack.pop() * this.ValueStack.pop());
//                     System.out.print(" = " + this.ValueStack.peek());
                 }
            }else {
                System.out.print(" " + s + " ");
                this.ValueStack.push(Double.parseDouble(s));
            }
        }
    }

    public void result(){
        System.out.println(" = " + this.ValueStack.pop());
    }
}
