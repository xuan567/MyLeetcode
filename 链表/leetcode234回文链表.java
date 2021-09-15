package 链表;

import java.util.ArrayList;
import java.util.List;

public class leetcode234回文链表 {
    /*
    给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
    如果是，返回 true ；否则，返回 false 。

    示例 1:
    输入：head = [1,2,2,1]
    输出：true

    示例 2：
    输入：head = [1,2]
    输出：false
    * */

    public boolean isPalindrome1(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }
        for(int i=0,j=list.size()-1; i<j; i++,j--){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow = head,fast = head;
        ListNode pre = head,prepre = null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while (pre!=null && slow!=null){
            if(pre.val!=slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
