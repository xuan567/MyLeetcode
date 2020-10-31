package string;

import java.util.HashMap;

public class leetcode925长按键入 {
    /*925. 长按键入难度简单87你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
    而字符可能被输入 1 次或多次。你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
    那么就返回 True。

    示例 1：
    输入：name = "alex", typed = "aaleex"
    输出：true
    解释：'alex' 中的 'a' 和 'e' 被长按。

    示例 2：
    输入：name = "saeed", typed = "ssaaedd"
    输出：false
    解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。

    示例 3：
    输入：name = "leelee", typed = "lleeelee"
    输出：true

    示例 4：
    输入：name = "laiden", typed = "laiden"
    输出：true
    解释：长按名字中的字符并不是必要的。
    1. 若字符串不为空，两个指针i，j分别指向name和typed的第一个字符；
    2. 开始比较，如果两个i，j指向的两个字符相等，则i、j均向后移动一位；
    3. 否则的话，判断j指向的字符是否为“长按”字符，即判断j指向的字符与j-1指向的字符是否相同，
        如果相同则j后移一位，否则返回false；
    4. 最后判断name与typed是否均已遍历完毕，是的话返回true。


    * */
    public static void main(String[] args) {
        boolean b = isLongPressedName("leelee", "lleeelee");
        System.out.println(b);
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;
        while(j<typed.length()){
            if(i<name.length() && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i==name.length();
    }
    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();

    }
}
