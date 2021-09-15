package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 中缀转后缀 {

    public static void main(String[] args) {
        String s = "1+1";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String l = dealEquation(toSuffix(sb));
        System.out.println(l);
    }

    private static final Map<Character,Integer> basic = new HashMap<Character, Integer>();
    static {
        basic.put('+',1);
        basic.put('-',1);
        basic.put('*',2);
        basic.put('/',2);
        basic.put('(',0);
    }

    private static String toSuffix(StringBuilder sb){
        char[] charArr = sb.substring(0,sb.length()).trim().toCharArray();
        List<Character> stack = new ArrayList<>();
        List<String> queue = new ArrayList<>();
        String stander = "+-*/()";
        int len = 0;
        char ch = '&';
        for(int i=0;i<charArr.length;i++){
            int last = 0;
            if(i>0){
                last = charArr[i-1];
            }
            ch = charArr[i];
            if(Character.isDigit(ch)){
                len++;
            }else if(ch=='.'){
                len++;
            }else if(ch=='-'&&(last=='*'||last=='/'||i==0)){
                len++;
                continue;
            }else if(stander.indexOf(ch)!=-1){
                if(len > 0){
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr,i-len,i)));
                    len=0;
                }
                if(ch=='('){
                    stack.add(ch);
                    continue;
                }
                if(!stack.isEmpty()){
                    boolean flag = false;
                    int size = stack.size()-1;
                    while(size >= 0 && ch==')'&& stack.get(size) !='('){
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                        flag = true;
                    }
                    if(ch==')'&&stack.get(size)=='('){
                        flag = true;
                    }
                    while(size >=0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)){
                        queue.add(String.valueOf(stack.remove(size)));
                        size--;
                    }
                }
                if(ch!=')'){
                    stack.add(ch);
                }else{
                    stack.remove(stack.size()-1);
                }
            }
            if(i==charArr.length-1){
                if(len  > 0 ){
                    queue.add(String.valueOf(Arrays.copyOfRange(charArr,i-len+1,i+1)));
                }
                int size = stack.size()-1;
                while(size>=0){
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                }
            }
        }
        String a = queue.toString();
        return a.substring(1,a.length()-1);
    }

    public static String dealEquation(String equation) {

        String[] arr = equation.split(", ");
        List<String> list = new ArrayList<String>();


        for (int i = 0; i < arr.length; i++) {
            int size = list.size();
            switch (arr[i]) {
                case "+":
                    double a = Double.parseDouble(list.remove(size - 2)) + Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(a));
                    break;
                case "-":
                    double b = Double.parseDouble(list.remove(size - 2)) - Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(b));
                    break;
                case "×":
                    double c = Double.parseDouble(list.remove(size - 2)) * Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(c));
                    break;
                case "/":
                    double d = Double.parseDouble(list.remove(size - 2)) / Double.parseDouble(list.remove(size - 2));
                    list.add(String.valueOf(d));
                    break;
                default:
                    list.add(arr[i]);
                    break;
            }
        }
        return list.size() == 1 ? list.get(0) : "运算失败";
    }
}
