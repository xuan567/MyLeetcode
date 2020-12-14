package 数组和字符串;

public class leetcode557反转字符串中的单词 {
    /*
    * 557. 反转字符串中的单词 III
    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
    示例：
    输入："Let's take LeetCode contest"
    输出："s'teL ekat edoCteeL tsetnoc"*/

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            StringBuilder l = new StringBuilder();
            l.append(arr[i]);
            sb.append(l.reverse().toString());
            if(i!=arr.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
