package 数组和字符串;

public class leetcode7整数反转 {
    /*
    * 7. 整数反转
        给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
        假设环境不允许存储 64 位整数（有符号或无符号）。


        示例 1：
        输入：x = 123
        输出：321
        示例 2：

        输入：x = -123
        输出：-321
        示例 3：

        输入：x = 120
        输出：21
        示例 4：

        输入：x = 0
        输出：0*/

    //题解：反转整数，定义一个ans=0，进入循环，ans = ans*10 + x/10，x=x/10，
    // 因为x可能是正数也可能是负数，所以循环条件是x！=0。因为不知道反转后的数字是否在范围内，
    // 当到最后一位时进行判断，ans > Integer.MAX_VALUE/10
    //或ans == Integer.MAX_VALUE/10 && pop > 7，肯定溢出，直接返回0，负数同理

    public int reverse(int x) {
        int ans = 0;
        while(x!=0){
            int pop = x%10;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7)){
                return 0;
            }
            if(ans <Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop <-8)){
                return 0;
            }
            ans = ans*10 + pop;
            x = x/10;
        }
        return ans;
    }
}
