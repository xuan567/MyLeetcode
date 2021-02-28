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
        String s2 = longestPalindrome3(s);
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

    //动态规划
    //对于一个子串，是回文串，并且长度大于2，将他的首位两个字母去除之后，仍然是回文串，所有动态规划转移方程为
    //p(i,j) = p(i+1,j-1)&&(Si == Sj)

    public static String longestPalindrome2(String s){
        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for(int l=0;l<n;l++){
            for(int i=0;i+l<n;i++){
                int j = i+l;
                if(l==0){
                    dp[i][j]=true;
                }else if(l==1){
                    dp[i][j]=(s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if(dp[i][j] && l+1 > ans.length()){
                    ans = s.substring(i,i+l+1);
                }
            }
        }
        return ans;
    }

    //中心扩散法
    //回文串的中心可能是一个字母，也可能是两个字母，将两种情况都列举出来，不断向两边扩展，
    //如果两边的字母相同，就可以继续扩展，不同，就返回长度，最后求出最长的长度
    //时间复杂度是O(n方),空间复杂度是O(1)
    //其中n是字符串的长度。长度为1和2的回文中心分别有n和n−1个,每个回文中心最多会向外扩展O(n)次

    public static String longestPalindrome3(String s){
        if(s.length()<1 || s==null){
            return "";
        }
        int end=0,start=0;
        for(int i=0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public static int expandAroundCenter(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }






    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int start=0,end=0,max=0,len=0;
        String l="" ;
        for(int i=0;i+1<s.length();i++){
            int l1 = aroundCenter(s,i,i);
            int l2 = aroundCenter(s,i,i+1);
            len = Math.max(l1,l2);
            start = i-(len-1)/2;
            end = i+len/2;
            if(len > max){
                l = s.substring(start,end+1);
            }
        }
        return l;

    }

    private int aroundCenter(String s,int left,int right){
        while(s.charAt(left)==s.charAt(right) && left>=0 && right<s.length()){
            left--;
            right++;
        }
        return left-right-1;
    }

}
