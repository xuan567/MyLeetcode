package 数组和字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode17电话号码的字母组合 {
    /*
    17. 电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    示例 1：
    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

    示例 2：
    输入：digits = ""
    输出：[]

    示例 3：
    输入：digits = "2"
    输出：["a","b","c"]

    提示：
    0 <= digits.length <= 4
    digits[i] 是范围 ['2', '9'] 的一个数字。
    * */

    //题解：回溯，再循环里面套递归调用
    //

    String[] letter_map = {"","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList();
        }
        iterStr(digits,new StringBuilder(),0);
        return list;
    }
    ArrayList list = new ArrayList();
    void iterStr(String s,StringBuilder letter,int index){
        if(index == s.length()){
            list.add(letter.toString());
            return;
        }
        char c = s.charAt(index);
        int pos = c-'0';
        String str = letter_map[pos];
        for(int i=0;i<str.length();i++){
            letter.append(str.charAt(i));
            iterStr(s,letter,index+1);
            letter.deleteCharAt(letter.length()-1);
        }
    }

}
