package 数组和字符串;

public class leetcode153寻找旋转排序数组中的最小值 {

    /*
      假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，
      数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
      请找出其中最小的元素。

        示例 1：
        输入：nums = [3,4,5,1,2]
        输出：1

        示例 2：
        输入：nums = [4,5,6,7,0,1,2]
        输出：0

        示例 3：
        输入：nums = [1]
        输出：1
        */

    //1.将数组遍历一遍，因为之前是按照升序排序的，然后在某个点上进行了旋转，所以如果nums[i]<nums[i-1],
    //可知在这里进行了旋转，因为是按照升序排序，所以nums[i]是最小的,将其返回，若便利了一遍没有找到，
    //则该数组没有旋转，返回num[0];
    //时间复杂度是O(n)

    public int findMin1(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }


//    //2.二分查找法
//
//    public int findMin2(int[] nums) {
//        int left = 0;
//        int right = nums.length-1;
//        while(left<right){
//            int might = (right-left)/2+left;
//            if(nums[left] < nums[might] ){
//                left = might;
//                left =
//            }else{
//
//            }
//        }
//    }

}
