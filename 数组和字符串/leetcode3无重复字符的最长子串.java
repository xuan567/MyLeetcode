package 数组和字符串;

import java.util.HashMap;

public class leetcode3无重复字符的最长子串 {

    /*
    * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
        示例1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

        示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

        示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

        示例 4:
        输入: s = ""
        输出: 0
        */

    public static void main(String[] args) {
        String s = "abba";
        int x = lengthOfLongestSubstring(s);
        System.out.println(x);
    }

    // 滑动窗口

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0,left=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                left = Math.max(left,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

}
