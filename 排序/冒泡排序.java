package 排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        bubbleSortPro2();
    }
    //冒泡排序

    private void bubbleSortPro1(int[] array){
        int[] arr = {4,2,8,5,1,10};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //冒泡排序的优化

    private static void bubbleSortPro2(){
        int[] arr = {4,2,8,5,1,10};
        for(int i=0;i<arr.length-1;i++){
            //提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
