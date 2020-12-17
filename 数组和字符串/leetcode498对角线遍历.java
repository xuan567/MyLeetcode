package 数组和字符串;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class leetcode498对角线遍历 {
    /*
    * 对角线遍历
        给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
        示例:
        输入:
        [
         [ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]
        ]

        输出:  [1,2,4,7,5,3,6,8,9]
   */

    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int index=0;
        int[] result = new int[M*N];
        for(int d=0;d<M+N-1;d++){
            ArrayList<Integer> list = new ArrayList<>();
            int r = d<M ?0:d-M;
            int c = d<M?d:M-1;
            while(c>-1&&r<N){
                list.add(matrix[r][c]);
                if(d%2!=0){
                    Collections.reverse(list);
                }
                for(int i=0;i<list.size();i++){
                    result[index++]=list.get(i);
                }
            }
        }
        return result;
    }
}
