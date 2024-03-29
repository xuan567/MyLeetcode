package 数组和字符串;

public class leetcode221最大正方形 {
    /*
    在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

    示例 1：
    输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],
                  ["1","1","1","1","1"],["1","0","0","1","0"]]
    输出：4

    示例 2：
    输入：matrix = [["0","1"],["1","0"]]
    输出：1
    * */

    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]=='1'){
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    }
                }
                maxSize = Math.max(maxSize,dp[i][j]);
            }
        }
        return maxSize*maxSize;
    }
}
