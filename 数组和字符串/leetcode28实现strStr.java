package 数组和字符串;

public class leetcode28实现strStr {
    /*
    * 28. 实现 strStr()
        实现 strStr() 函数。
        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

        示例 1:
        输入: haystack = "hello", needle = "ll"
        输出: 2
        *
        示例 2:
        输入: haystack = "aaaaa", needle = "bba"
        输出: -1
        * */

    //思路:如果haystack.equals(needle)，直接返回0
    //测出needle的长度，遍历haystack，substring(i,i+len).equals(needle),返回i
    //如果遍历完后没有找到needle，返回-1;

    public static void main(String[] args) {
        String haystack="aaaaa";
        String needle="bba";
        int n = strStr(haystack,needle);
        System.out.println(n);
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        int len = needle.length();
        for(int i=0;i+len<=haystack.length();i++){
            if(haystack.substring(i,i+len).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
