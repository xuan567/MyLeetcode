package 剑指Offer;

public class 剑指offer04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while (i>=0 && j<matrix[0].length){
            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
