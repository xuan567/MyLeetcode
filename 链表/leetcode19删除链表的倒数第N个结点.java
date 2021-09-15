package 链表;

public class leetcode19删除链表的倒数第N个结点 {
  /*
      * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
        进阶：你能尝试使用一趟扫描实现吗？

        示例 1：
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]

        示例 2：
        输入：head = [1], n = 1
        输出：[]

        示例 3：
        输入：head = [1,2], n = 1
        输出：[1]

    */

    //题解：因为删除的是倒数第n个元素，所以每次删除前反转列表，分为三种情况
    //1.如果n<=0，直接返回头指针
    //2.如果n==1，删除的是最后一个节点，反转列表，删除头节点，然后再反转列表
    //3.如果n>=2,先反转链表，然后遍历到第n个节点的前一个节点，然后删除，然后再反转回来
    //最后返回头节点

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n){
        if(n<=0){
            return head;
        }else if(n==1){
            head = reverse(head);
            head = head.next;
            head = reverse(head);
            return head;
        }else{
            head = reverse(head);
            ListNode p = head;
            while (n>2){
                p=p.next;
                n--;
            }
            p.next = p.next.next;
            head = reverse(head);
            return head;
        }
    }

    public ListNode reverse(ListNode l){
         if(l==null || l.next==null){
             return l;
         }
         ListNode h = null;
         ListNode p=l,q;
         while (p!=null){
             q=p.next;
             p.next = h;
             h=p;
             p=q;
         }
         return h;
    }
}
