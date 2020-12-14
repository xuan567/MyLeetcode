package 数组和字符串;

public class leetcode283移动零 {
    /*
    * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        示例:
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]*/

    public static void main(String[] args) {
        int[] nums = { 0,1,0,3,12 };
        moveZeroes3(nums);
    }
    public static void moveZeroes1(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void moveZeroes2(int[] nums){
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(int i=j;j<nums.length;j++){
            nums[j]=0;
        }

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static void moveZeroes3(int[] nums){
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i]!=0){
                if(i>j){
                    nums[j]=nums[i];
                    nums[i]=0;
                }
                j++;
            }
            i++;
        }
        for(i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

}
