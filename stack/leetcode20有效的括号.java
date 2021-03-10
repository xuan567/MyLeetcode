package stack;

import java.util.Stack;

public class leetcode20有效的括号 {
    /*
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，
    * 判断字符串是否有效。有效字符串需满足：
      左括号必须用相同类型的右括号闭合。
      左括号必须以正确的顺序闭合。

        示例 1：
        输入：s = "()"
        输出：true

        示例2：
        输入：s = "()[]{}"
        输出：true

        示例3：
        输入：s = "(]"
        输出：false

        示例4：
        输入：s = "([)]"
        输出：false

        示例5：
        输入：s = "{[]}"
        输出：true
        */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }else if(s.charAt(i)==']'){
                if(stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            }else if(s.charAt(i)=='}'){
                if(stack.isEmpty() || stack.pop()!='{'){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

}
