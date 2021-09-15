package 栈;

import java.util.Stack;

public class 逆波兰表达式求值 {
    /*
    * 根据 逆波兰表示法，求表达式的值。
    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
    *
    说明：
    整数除法只保留整数部分。
    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

    示例 1：
    输入: ["2", "1", "+", "3", "*"]
    输出: 9
    解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

    示例 2：
    输入: ["4", "13", "5", "/", "+"]
    输出: 6
    解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6*/

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }
    public static int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch (tokens[i]){
                case "+":
                    a =stack.pop();
                    b = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    a =stack.pop();
                    b = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    a =stack.pop();
                    b = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    a =stack.pop();
                    b = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}

/*
* public int evalRPN(String[] tokens) {
        int a,b;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch (tokens[i]){
                case "+":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a+b));
                    break;
                case "-":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a-b));
                    break;
                case "*":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a*b));
                    break;
                case "/":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a/b));
                    break;
                default:
                    stack.push(String.valueOf(tokens[i]));
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }*/
