package 数组和字符串;

import java.util.Arrays;

public class leetcode88合并两个有效数组 {
    /*
    * 给你两个有序整数数组nums1和nums2，请你将nums2合并到nums1中，使nums1成为一个有序数组。
    初始化nums1和nums2的元素数量分别为m和n。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自nums2的元素。

    示例 1：
    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    输出：[1,2,2,3,5,6]

    示例 2：
    输入：nums1 = [1], m = 1, nums2 = [], n = 0
    输出：[1]
        * */

    //1.题解：将nums2的所有元素都挪到nums1下标m之后，然后将nums1排序

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //2.题解：两个数组都从后向前遍历，将大的从后面开始放，当len<0时，遍历结束，如果nums2此时
    //还剩下元素，则将剩下的元素都拷贝到nums1的前面

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m-1;
        int len2 = n-1;
        int len = m+n-1;

        while(len1>=0 && len2>=0){
            nums1[len--] = nums1[len1]>nums2[len2]?nums1[len1--]:nums2[len2--];
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);

    }
}
