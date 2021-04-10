package 数组和字符串;

public class leetcode34在排序数组中查找元素的第一个和最后一个位置 {

        /*
        给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回[-1, -1]。
        进阶：
        你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

        示例 1：
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]

        示例2：
        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]

        示例 3：
        输入：nums = [], target = 0
        输出：[-1,-1]

        * */


    //方法一：设置一个标记t记录target的数量，当t==1时，直接让arr[0]=i
    //如果t>1,让arr[1]=target,直至遍历完
    //最后判断如果arr[1]还是等于-1，那么target只有一个，让arr[1]=arr[0];
    //返回arr;

    public int[] searchRange1(int[] nums, int target) {
        int[] arr = new int[]{-1,-1};
        int t=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                t++;
                if(t==1){
                    arr[0]=i;
                }else if(t>1){
                    arr[1]=i;
                }
            }
        }
        if(arr[0]!=-1 && arr[1]==-1){
            arr[1]=arr[0];
        }
        return arr;

    }


    //二分查找的基本用法是在一个有序数组里查找目标元素，具体是看区间中间元素的值 nums[mid] 与 target 的大小关系。
    //如果等于，就可以直接返回；
    //如果严格大于，就往右边查找；
    //如果严格小于，就往左边查找。
    //先找第一个出现的元素，然后找最后一个出现的元素

    public int[] searchRange2(int[] nums, int target){
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int firstPosition = findFirstPosition(nums,target);
        if(firstPosition==-1){
            return new int[]{-1,-1};
        }
        int lastPosition = findLastPosition(nums,target);
        return new int[]{firstPosition,lastPosition};
    }

    private int findFirstPosition(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                right=mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        if(left!=nums.length && nums[left]==target){
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                left = mid+1;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }
}
