package 数组和字符串;

public class leetcode75颜色分类 {

    /*
    * 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，
    * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

        此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
        示例 1：
        输入：nums = [2,0,2,1,1,0]
        输出：[0,0,1,1,2,2]

        示例 2：
        输入：nums = [2,0,1]
        输出：[0,1,2]

        示例 3：
        输入：nums = [0]
        输出：[0]

        示例 4：
        输入：nums = [1]
        输出：[1]

    * */

    //思路：
    //下标j记录每次交换的坐标
    //遍历整个数组，遍历两遍，第一遍找到所有0元素，找到之后与nums[j]交换，j++
    //第二遍找1元素
    //当所有0和1元素找到后，就只剩下2元素了

    public void sortColors(int[] nums) {
        int i,j=0;
        for(i=j;i<nums.length;i++){
            if(nums[i]==0){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }

        for(i=j;i<nums.length;i++){
            if(nums[i]==1){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }

    }

}
