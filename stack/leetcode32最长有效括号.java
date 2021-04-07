package stack;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode32最长有效括号 {

    /*
    * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。

        示例 1：
        输入：s = "(()"
        输出：2
        解释：最长有效括号子串是 "()"

        示例 2：
        输入：s = ")()())"
        输出：4
        解释：最长有效括号子串是 "()()"


        示例 3：
        输入：s = ""
        输出：0

    * */

    //1.动态规划
    //2.栈
    //3.正向逆向结合法


    //栈：通过栈，可以在遍历给定字符串的过程中判断目前为止扫描的子串的有效性，同时得到最长有效括号的长度
    //考虑了边界元素的处理，始终保持栈底元素为当前已经遍历过的元素【最后一个没有匹配的有括号的下标】，刚开始栈为空，往栈中放入-1
    //当遇到'('时，下标入栈
    //当遇到')'时：弹出栈顶元素表示匹配了当前的右括号
    //           1.栈为空：当前右括号没有被匹配，将其下标放入栈中，就是之前的【最后一个没有匹配的有括号的下标】
    //           2.栈不空：当前右括号的下标减去栈顶元素，max = Math.max(max,i-stack.peek())

    public int longestValidParentheses2(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    //正向逆向结合法
    //定义一个整型left和right，记录左括号和右括号的数量
    //当从左向右遍历时，当left==right，max=Math.max(max,left*2);当right>left,此时括号已经不配对了，left=right=0；
    //然后再从右向左遍历，然后判断max；

    public int longestValidParentheses3(String s) {
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(right==left){
                max=Math.max(max,left*2);
            }else if(right>left){
                left = right=0;
            }
        }

        left=0;
        right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(right==left){
                max=Math.max(max,right*2);
            }else if(left>right){
                right=left =0;
            }
        }

        return max;

    }


    public int longestValidParentheses1(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2 ?dp[i-2]:0)+2;
                }else if (i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1] +((i-dp[i-1])>=2 ?dp[i-dp[i-1]-2]:0)+2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
