package 链表;

public class leetcode21合并两个有序链表 {
    /*
    * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
        示例 1：
        输入：l1 = [1,2,4], l2 = [1,3,4]
        输出：[1,1,2,3,4,4]

        示例 2：
        输入：l1 = [], l2 = []
        输出：[]

        示例 3：
        输入：l1 = [], l2 = [0]
        输出：[0]
            * */

    //题解：新建节点l3,p,p=l3,遍历l1，l2比较大小，循环的条件是l1！=null && l2！=null
    //比较l1.val和l2.val的大小，p.next就等于其中小的，同时移动p和小的指针，直到遍历完l1
    //或l2其中一个，剩下的直接接到p的后面，最后返回l3

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
