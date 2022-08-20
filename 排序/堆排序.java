package 排序;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {4,3,6,1,9,7};
        headSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

    }
    public static void headSort(int[] array){
        int n = array.length;
        //构建大顶堆
        for(int i=(n-2)/2;i>=0;i--){
            downAdjust(array,i,n-1);
        }
        //进行堆排序
        for(int i=n-1;i>=1;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array,0,i-1);
        }


    }

    public static void downAdjust(int[] arr,int parent,int n){
        int temp = arr[parent];
        int child = 2*parent + 1;
        while (child <= n){
            if(child+1<=n && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[child] <= temp){
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = 2*parent +1;
        }
        arr[parent] = temp;
    }
}
