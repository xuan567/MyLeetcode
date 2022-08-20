package 排序;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        insertSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertSort(int[] arr){
        if (arr.length < 2) {
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int cur = arr[i+1];
            int pre = i;
            while(pre >= 0 && cur < arr[pre]){
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = cur;
        }
    }

}
