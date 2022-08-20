package 排序;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        ShellSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void ShellSort(int[] arr){
        int len = arr.length;
        if(len < 2){
            return;
        }
        int cur,gap = len/2;
        while (gap > 0){
            for(int i = gap;i<len;i++){
                cur = arr[i];
                int pre = i-gap;
                while(pre >=0 && arr[pre] > cur){
                    arr[pre+gap] = arr[pre];
                    pre -= gap;
                }
                arr[pre+gap] = cur;
            }
            gap/=2;
        }
    }
}
