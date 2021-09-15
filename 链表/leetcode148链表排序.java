package 链表;

import java.util.List;

public class leetcode148链表排序 {
    /*
    给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
    进阶：
    你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

    示例 1：
    输入：head = [4,2,1,3]
    输出：[1,2,3,4]

    示例 2：
    输入：head = [-1,5,3,4,0]
    输出：[-1,0,3,4,5]

    示例 3：
    输入：head = []
    输出：[]

    * */

    //归并排序

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head.next,slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h = new ListNode(0);
        ListNode temp = slow.next;
        slow.next = null;
        ListNode res = h;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        while(left!=null && right!=null){
            if(left.val<right.val){
                h.next = left;
                left = left.next;
            }else{
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left!=null?left:right;
        return res.next;
    }
}
