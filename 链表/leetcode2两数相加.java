package 链表;

public class leetcode2两数相加 {
    /*
    * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
      请你将两个数相加，并以相同形式返回一个表示和的链表。
      你可以假设除了数字 0 之外，这两个数都不会以 0开头。

      示例 1：
      输入：l1 = [2,4,3], l2 = [5,6,4]
      输出：[7,0,8]
      解释：342 + 465 = 807.

      示例 2：
      输入：l1 = [0], l2 = [0]
      输出：[0]

      示例 3：
      输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
      输出：[8,9,9,9,0,0,0,1]
     * */

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1!=null || l2!=null){
            int x = l1==null ? 0:l1.val;
            int y = l2==null ? 0:l2.val;
            int sum = x+y+carry;
            carry = sum/10;
            sum = sum%10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry==1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}

