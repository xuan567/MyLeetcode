package 数组和字符串;

public class leetcode14最长公共前缀 {
    /*
    * 14. 最长公共前缀
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。

        示例 1:
        输入: ["flower","flow","flight"]
        输出: "fl"

        示例 2:
        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。*/

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        String s ="";
        StringBuilder sb = new StringBuilder();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                s = strs[i];
            }
        }
        int flag=0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
