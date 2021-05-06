package 动态规划;

public class leetcode64最小路径和 {
    /*
    给定一个包含非负整数的 m x n 网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。

    示例 1：
    输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    输出：7
    解释：因为路径 1→3→1→1→1 的总和最小

    示例 2：
    输入：grid = [[1,2,3],[4,5,6]]
    输出：12

    * */

    //思路：
    // 这道题不需要建立dp矩阵浪费空间，可以直接遍历grid
    // 因为每次只能向右或者向下，所以走到该格子的最小路径=Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
    // 每次判断，当i==0 && j==0 ,跳出
    // 当i==0 && j!=0 , grid[i][j] = grid[i][j-1]+grid[i][j];
    // 当j==0 && i!=0 , grid[i][j] = grid[i-1][j]+grid[i][j];
    // 最后return grid[m-1][n-1]

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }else if(i==0){
                    grid[i][j] = grid[i][j-1]+grid[i][j];
                }else if(j==0){
                    grid[i][j] = grid[i-1][j]+grid[i][j];
                }else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
