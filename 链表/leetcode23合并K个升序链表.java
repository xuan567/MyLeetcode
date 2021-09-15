package 链表;

public class leetcode23合并K个升序链表 {
    /*
            给你一个链表数组，每个链表都已经按升序排列。
        请你将所有链表合并到一个升序链表中，返回合并后的链表。

        示例 1：
        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        解释：链表数组如下：
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        将它们合并到一个有序链表中得到。
        1->1->2->3->4->4->5->6

        示例 2：
        输入：lists = []
        输出：[]

        示例 3：
        输入：lists = [[]]
        输出：[]

        * */

    //题解：新建一个空链表ans，遍历链表lists，每次合并lists[i]和ans，

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        for(int i=0;i<lists.length;i++){
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans.next;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode l3 = new ListNode();
        ListNode p = l3;

        while(l1!=null && l2 !=null){
            if(l1.val < l2.val ){
                p.next = l1;
                p=l1;
                l1=l1.next;
            }else{
                p.next = l2;
                p=l2;
                l2 = l2.next;
            }
        }
        if(l2==null){
            p.next=l1;
        }else if(l1==null){
            p.next=l2;
        }
        return l3.next;
    }
}
