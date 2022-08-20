package 剑指Offer;

public class 打印从1到最大的n位数 {

    /*
    剑指 Offer 17. 打印从1到最大的n位数
    输入数字 n，按顺序打印出从1到最大的n位十进制数。
    比如输入 3，则打印出 1、2、3一直到最大的3位数999。

    示例 1:
    输入: n = 1
    输出: [1,2,3,4,5,6,7,8,9]


    说明：
    用返回一个整数列表来代替打印
    n 为正整数
    * */

    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for(int digit = 1; digit <= n; digit++){
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }

}
