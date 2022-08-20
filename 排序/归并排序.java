package 排序;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        MergeSort(arr,0,arr.length);

    }

    public static void MergeSort(int[] array,int left,int right){
        if(left < right-1){
            int mid = left + (right-left+1)/2;
            //对左半部分进行排序
            MergeSort(array,left,mid);
            //对右半部分进行排序
            MergeSort(array,mid,right);
            //进行合并
            merge(array,left,mid,right);
        }
    }

    public static void merge(int[] array,int left,int mid,int right){
        int[] a = new int[right - left];
        int i = left;
        int j = mid;
        int k=0;
        while(i<mid && j<right){
            if(array[i] < array[j]){
                a[k++] = array[i++];
            }else{
                a[k++] = array[j++];
            }
        }
        while(i<mid){
            a[k++] = array[i++];
        }
        while(j<right){
            a[k++] = array[j++];
        }

        //把临时数组复制到原数组
        for(i=0;i<k;i++){
            array[left++] = a[i];
        }
    }

}
