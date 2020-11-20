package 数组和字符串;

public class leetcode5最长回文子串 {
    /*
    * 给定一个字符串 s，找到 s 中最长的回文子串。
        示例 1：
        输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。

        示例 2：
        输入: "cbbd"
        输出: "bb"*/

    public static void main(String[] args) {
        String s = "cbbd";
        String s2 = longestPalindrome1(s);
        System.out.println(s2);
    }
    //暴力
    public static String longestPalindrome1(String s) {
        String ans = "";
        int len = 1;
        while(len<=s.length()) {
            for (int i = 0; i+len <= s.length(); i++) {
                String t = s.substring(i,i+len);
                if(isHuiwen(t)){
                    if(ans.length() < t.length()){
                        ans = t;
                    }
                }
            }
            len++;
        }
        return ans;
    }
    public static boolean isHuiwen(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    //

}
