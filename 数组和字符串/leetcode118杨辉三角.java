package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

public class leetcode118杨辉三角 {
    /*
    * 118. 杨辉三角
        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
        在杨辉三角中，每个数是它左上方和右上方的数的和。

        示例:
        输入: 5
        输出:
        [
             [1],
            [1,1],
           [1,2,1],
          [1,3,3,1],
         [1,4,6,4,1]
        ]*/

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists = generate(5);
        System.out.println(lists);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int t=1;
        while(t<=numRows){
            List<Integer> list1 = new ArrayList<>();
            if(t==1){
                list1.add(1);
            }else if(t==2){
                list1.add(1);
                list1.add(1);
            }else{
                List<Integer> list2 = list.get(list.size()-1);
                list1.add(1);
                for(int i=1;i<list2.size();i++){
                    list1.add(list2.get(i)+list2.get(i-1));
                }
                list1.add(1);
            }
            list.add(list1);
            t++;
        }
        return list;
    }
}
