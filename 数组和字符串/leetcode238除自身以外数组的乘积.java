package 数组和字符串;

public class leetcode238除自身以外数组的乘积 {
    /*
    给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
    其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。

    示例:
    输入: [1,2,3,4]
    输出: [24,12,8,6]
    提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）
    的乘积都在 32 位整数范围内。
    说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    进阶：
    你可以在常数空间复杂度内完成这个题目吗？
    （ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
    */

    //题解：算出前缀乘积，再算出后缀乘积
    //然后前缀乘积乘后缀乘积得出结果
    //时间复杂度：O(n)，其中 n 指的是数组 nums 的大小
    //空间复杂度：O(n)，其中 n 指的是数组 nums 的大小

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] back = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
        back[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            back[j] = back[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            pre[i] = pre[i] * back[i];
        }
        return pre;
    }

    //进阶
    public int[] productExceptSelf1(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        int R = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            answer[j] = answer[j] * R;
            R = R * nums[j];
        }
        return answer;
    }
}
