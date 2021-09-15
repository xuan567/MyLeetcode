package 数组和字符串;

public class leetcode240搜索二维矩阵 {
    /*
    编写一个高效的算法来搜索mxn矩阵matrix中的一个目标值target。
    该矩阵具有以下特性：

    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。

    示例 1：

    输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
    [10,13,14,17,24],[18,21,23,26,30]], target = 5
    输出：true
    示例 2：


    输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],
    [10,13,14,17,24],[18,21,23,26,30]], target = 20
    输出：false

        * */

    /*题解：
    首先，我们初始化一个指向矩阵左下角的 (row，col)(row，col) 指针。
    然后，直到找到目标并返回 true（或者指针指向矩阵维度之外的 (row，col)(row，col) 为止
    如果当前指向的值大于目标值，则可以 “向上” 移动一行。
    否则，如果当前指向的值小于目标值，则可以移动一列。

    时间复杂度：O(n+m)。
    时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，
    行或列都会精确地递减/递增一次。由于行只能减少m次，而列只能增加n次，
    因此在导致 while 循环终止之前，循环不能运行超过n+m次。

    空间复杂度：O(1)，因为这种方法只处理几个指针，所以它的内存占用是恒定的
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j=0;
        while(i>=0 && j<matrix[0].length){
            if(target < matrix[i][j]){
                i--;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

}
