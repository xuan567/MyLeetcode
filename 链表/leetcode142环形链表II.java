package 链表;

import java.util.HashSet;
import java.util.Set;

public class leetcode142环形链表II {
    /*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
    说明：不允许修改给定的链表。
    进阶：
    你是否可以使用 O(1) 空间解决此题？

    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：返回索引为 1 的链表节点
    解释：链表中有一个环，其尾部连接到第二个节点。

    示例2：
    输入：head = [1,2], pos = 0
    输出：返回索引为 0 的链表节点
    解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
    输入：head = [1], pos = -1
    输出：返回 null
    解释：链表中没有环。
    */

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //题解：找到步数的关系，相遇后，让fast=head，当fast再次相遇low时
    //这个相遇的节点就是环形链表的入口

    public ListNode detectCycle2(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast,low;
        fast = head;
        low = head;
        while(true){
            if(fast==null || fast.next==null){
                return null;
            }
            fast = fast.next.next;
            low = low.next;
            if(fast==low){
                break;
            }
        }
        fast=head;
        while (fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return fast;

    }

}
