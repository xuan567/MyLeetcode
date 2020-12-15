package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

public class leetcode面试题零矩阵 {
    /*
    * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
        示例 1：
        输入：
        [
          [1,1,1],
          [1,0,1],
          [1,1,1]
        ]
        输出：
        [
          [1,0,1],
          [0,0,0],
          [1,0,1]
        ]          */

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);

    }
    public static void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> column = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for(int i=0;i<row.size();i++){
            int x = row.get(i);
            for(int j=0;j<matrix[x].length;j++){
                matrix[x][j]=0;
            }
        }
        for(int i=0;i<column.size();i++){
            int y = column.get(i);
            for(int j=0;j<matrix.length;j++){
                matrix[j][y]=0;
            }
        }
    }
}
