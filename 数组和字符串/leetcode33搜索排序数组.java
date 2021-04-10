package 数组和字符串;

public class leetcode33搜索排序数组 {

    /*
    * 33. 搜索旋转排序数组
        整数数组 nums 按升序排列，数组中的值 互不相同 。
        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
        使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
        （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
        给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

        示例 1：
        输入：nums = [4,5,6,7,0,1,2], target = 0
        输出：4

        示例 2：
        输入：nums = [4,5,6,7,0,1,2], target = 3
        输出：-1

        示例 3：
        输入：nums = [1], target = 0
        输出：-1

    * */

    //直接遍历时间复杂度是O(n);

    public int search1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    //二分法，时间复杂度log(n)
    //先根据nums[mid]和nums[lo]的关系判断mid是在左段还是右段，接下来再判断target是在mid的左边还是右边从而调整lo和hi

    public int search2(int[] nums, int target) {
        int low = 0,height = nums.length-1,mid = 0;
        while(low<=height){
            mid = low + (height - low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid] >= nums[low]){
                if(target<nums[mid] && target>=nums[low]){
                    height = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[height]){
                    low = mid+1;
                }else{
                    height = mid-1;
                }
            }
        }
        return -1;
    }
}
