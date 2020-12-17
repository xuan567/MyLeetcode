package 数组和字符串;

public class leetcode面试题0107旋转矩阵 {
    /*
    * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
        不占用额外内存空间能否做到？
        给定 matrix =
        [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ],
        原地旋转输入矩阵，使其变为:
        [
          [7,4,1],
          [8,5,2],
          [9,6,3]
        ]*/

    //题解：根据规律可先将数组按照主对角线交换，然后再根据每行的中点交换

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=matrix[0].length-1;j>i;j--){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length/2;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1]=t;
            }
        }

    }

}
