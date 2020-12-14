package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

public class leetcode119杨辉三角2 {

    /*
    * 给定一个非负索引k，其中 k≤33，返回杨辉三角的第 k 行。
      在杨辉三角中，每个数是它左上方和右上方的数的和。
      示例:
      输入: 3
      输出: [1,3,3,1]
        */

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        int t=0;
        while(t<=rowIndex+1){
            List<Integer> list1 = new ArrayList<>();
            if(t==0){
                list1.add(1);
            }else if(t==1){
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
        return list.get(list.size()-1);
    }
}
