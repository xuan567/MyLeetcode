package 排序;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {4,2,8,5,1,10};
        int min = 0;
        for(int i=0;i<arr.length-1;i++){
            min=i;
            for(int j=i;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
