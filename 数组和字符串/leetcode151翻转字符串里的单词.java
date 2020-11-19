package 数组和字符串;

public class leetcode151翻转字符串里的单词 {
    /*
    * 给定一个字符串，逐个翻转字符串中的每个单词。
        说明：
        无空格字符构成一个 单词 。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

        示例 1：
        输入："the sky is blue"
        输出："blue is sky the"*/

    public static void main(String[] args) {
        String s = "a good   example";
        String s2 = reverseWords(s);
        System.out.println(s2);
    }
    public static String reverseWords(String s) {
        String str = s.trim();
        String[] arr = str.split("\\s+");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            arr[i] = arr[i].trim();
            System.out.println(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int j=arr.length-1;j>=0;j--){
            sb.append(arr[j]);
            if(j>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
