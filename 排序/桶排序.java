package 排序;

import java.util.ArrayList;
import java.util.Collections;

public class 桶排序 {
    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }

        //计算桶的数量
        int bucketNum = (max-min)/arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i=0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<>());
        }

        //将每个元素放入桶
        for(int i=0;i<arr.length;i++){
            int num = (arr[i] - min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i=0;i<bucketArr.size();i++){
            Collections.sort(bucketArr.get(i));
        }

        //将桶中的元素赋值到原序列
        int index = 0;
        for(int i=0;i<bucketArr.size();i++){
            for(int j=0;j<bucketArr.get(i).size();j++){
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }

}
