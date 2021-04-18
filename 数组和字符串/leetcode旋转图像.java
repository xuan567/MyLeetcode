package 数组和字符串;

public class leetcode旋转图像 {

    /*
    48. 旋转图像
        给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

        示例 1：
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[[7,4,1],[8,5,2],[9,6,3]]

        示例 2：
        输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

        示例 3：
        输入：matrix = [[1]]
        输出：[[1]]

        示例 4：
        输入：matrix = [[1,2],[3,4]]
        输出：[[3,1],[4,2]]
    * */

    //先将数组按照对角线交换值，然后再按照中线交换就是旋转后的数组

    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j< matrix.length;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix.length/2;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = t;
            }
        }
    }

}
