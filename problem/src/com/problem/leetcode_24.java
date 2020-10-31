package com.problem;

public class leetcode_24 {

	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		

	}
	
    public ListNode swapPairs1(ListNode head) {
    	ListNode pre = new ListNode(0);
    	if(head==null||head.next==null)
    		return head;
    	pre.next=head;
    	ListNode temp,start,end;
    	temp = pre;
    	start = head;
    	end = head.next;
    	
    	while(temp.next!=null&&temp.next.next!=null) {
    		temp.next = end;
    		start.next = end.next;
    		end.next = start;
    		temp = start;
    		start = temp.next;
    		end = temp.next.next;
    	}
    	return pre.next;
    }
    
    public ListNode swapPairs2(ListNode head) {
    	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode next = head.next;
    	head.next=swapPairs2(next.next);
    	next.next=head;
    	return next;
    	
    }

}

