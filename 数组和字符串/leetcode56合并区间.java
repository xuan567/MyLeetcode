package 数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode56合并区间 {
    /*
    * 56. 合并区间
        给出一个区间的集合，请合并所有重叠的区间。
        示例 1:
        输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        示例 2:

        输入: intervals = [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。*/
//首先将数组排序，根据int[i][0]的大小排序，然后将排序后的数组遍历，定义一个res[][]，
//1.如果index==-1 || interval[0] > res[index][1]，说明此区间和之前的区间没有重叠将此区间添加到res
//2.否则，res[index][1] = Math.max(res[index][1],interval[1])，更新下标

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] out = merge(intervals);
        for(int i=0;i<out.length;i++){
            for(int j=0;j<2;j++) {
                System.out.print(intervals[i][j]);
            }
            System.out.println();
        }

    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        int [][]res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval:intervals) {
            if(index==-1 || interval[0] > res[index][1] ){
                res[++index] = interval;
            }else{
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }

}
