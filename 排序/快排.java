package 排序;

public class 快排 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low<high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, index + 1, high);
            quickSort(arr, low, index - 1);
        }
    }

    public static int getIndex(int[] arr,int low,int high){
        int temp = arr[low];
        while(low < high){
            while (low<high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
