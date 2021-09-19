package 数组和字符串;

import java.util.HashMap;

public class Leetcode287寻找重复数 {
    /*
    给定一个包含n+1个整数的数组nums ，其数字都在1到n之间（包括1和n），
    可知至少存在一个重复的整数。
    假设 nums 只有 一个重复的整数 ，找出 这个重复的数。
    你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。

    示例 1：
    输入：nums = [1,3,4,2,2]
    输出：2

    示例 2：
    输入：nums = [3,1,3,4,2]
    输出：3

    示例 3：
    输入：nums = [1,1]
    输出：1

    示例 4：
    输入：nums = [1,1,2]
    输出：1
    * */

    //题解1：hashmap法

    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer key : map.keySet()){
            if(map.get(key)!=1){
                return key;
            }
        }
        return 0;
    }

    //题解二：二分法
    /*
    长度为n+1的数组，数值在1到n之间。因此长度为len，数值在1到len-1之间;
    1. 使用 while (left<right)与right=mid;和left=mid+1;
       配对的写法是为了保证退出循环以后left与right重合，
       left（或者right）就是我们要找的重复的整数；
    2. 在循环体内，先猜一个数mid，然后遍历「输入数组」，统计小于等于mid的元素个数cnt，
       如果 cnt>mid说明重复元素一定出现在[left..mid]因此设置 right = mid；
       用一个具体的例子来理解：
       如果遍历一遍输入数组，统计小于等于4的元素的个数，如果小于等于4的元素的个数
       严格大于4，说明重复的元素一定出现在整数区间 [1..4]，依然是利用「抽屉原理。

    时间复杂度：O(N \log N)
             二分法的时间复杂度为 O(\log N)，在二分法的内部，执行了一次for循环，
             时间复杂度为 O(N)，故时间复杂度为)O(NlogN)。
    空间复杂度：O(1)，使用了一个cnt变量，因此空间复杂度为O(1)。

    * */

    public int findDuplicate2(int[] nums){
        int len = nums.length;
        int left = 1;
        int right = len-1;
        while(left<right){
            int mid = left+(right-left)/2;
            int cnd = 0;
            for(int num:nums){
                if(num <= mid){
                    cnd +=1;
                }
            }
            if(cnd > mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    /*
    题解三：
    整数的数组 nums 中的数字范围是 [1,n]
    1.如果数组中没有重复的数，以数组[1,3,4,2]为例，我们将数组下标n和数nums[n]
      建立一个映射关系 f(n)f(n)，其映射关系 n->f(n)为：
      0->1，1->3，2->4，3->2
      我们从下标为0出发，根据f(n)计算出一个值，以这个值为新的下标，再用这个函数计算，
      以此类推，直到下标超界。这样可以产生一个类似链表一样的序列。
      0->1->3->2->4->null

    2.如果数组中有重复的数，以数组[1,3,4,2,2]为例,我们将数组下标n和数nums[n]建立一个映射关系 f(n)f(n)，
      其映射关系 n->f(n) 为：
      0->1，1->3，2->4，3->2，4->2
      同样的，我们从下标为0出发，根据f(n)计算出一个值，以这个值为新的下标，
      再用这个函数计算，以此类推产生一个类似链表一样的序列。
      0->1->3->2->4->2->4->2->……
      从理论上讲，数组中如果有重复的数，那么就会产生多对一的映射，这样，
      形成的链表就一定会有环路了，
    综上
    1.数组中有一个重复的整数 <==> 链表中存在环
    2.找到数组中的重复整数 <==> 找到链表的环入口
    运用快慢指针
    * */

    public int findDuplicate3(int[] nums){
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1!=pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return  pre1;
    }
}
