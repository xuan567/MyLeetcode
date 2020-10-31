package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 每日温度 {

    /*
    * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，
    * 请在该位置用 0 来代替。
    例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    *
    * 自己思路：新建一个数组arr用于记录，第一重循环遍历数组中的元素，第二重循环，遍历该元素之后的元素，如果之后的有元素大于该元素，
    * arr[i]=j-i,然后直接跳出第二重循环，设置一个标志=true，如果第二重循环完后，标志==false，说明之后没有大于该元素的元素，
    * arr[i]=0。最后直接返回arr；
    */
    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] T1 = dailyTemperatures2(T);
        for (int i : T1) {
            System.out.print(i + " ");
        }
    }
    public static int[] dailyTemperatures1(int[] T) {
        int[] arr = new int[T.length];
        for(int i=0;i<T.length-1;i++){
            boolean flag = false;
            for(int j=i+1;j<T.length;j++){
                if(T[j] > T[i]){
                    arr[i]= j-i;
                    flag = true;
                    break;
                }
            }
            if(flag==false){
                arr[i] = 0;
            }
        }
        arr[T.length-1]=0;
        return arr;
    }

    public static int[] dailyTemperatures2(int[] T){
        int arr[] = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<T.length;i++){
            int t = T[i];
            while(!stack.isEmpty() && T[stack.peek()] < t){
                int preI = stack.pop();
                arr[preI] = i - preI;
            }
            stack.push(i);
        }
        return arr;
    }
}
