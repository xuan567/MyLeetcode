package stack;

import java.util.HashMap;
import java.util.Stack;

public class 有效字符串 {
    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    示例 1:
    输入: "()"
    输出: true

    示例 2:
    输入: "()[]{}"
    输出: true*/

    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        if(s.length()==0)
            return true;
        if(s.length()==1)
            return false;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('||arr[i]=='{'||arr[i]=='['){
                stack.push(arr[i]);
            }else if(arr[i]==')'&&stack.peek()=='('){
                stack.pop();
            }else if(arr[i]==']'&&stack.peek()=='[') {
                stack.pop();
            }else if(arr[i]=='}'&&stack.peek()=='{'){
                stack.pop();
            }else{
                flag = false;
                break;
            }
        }
        if(flag == false)
            return false;
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
