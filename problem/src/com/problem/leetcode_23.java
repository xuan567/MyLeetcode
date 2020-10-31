package com.problem;

import java.util.PriorityQueue;

public class leetcode_23 {

	  public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }


	public void main(String[] args) {

	}
	
	
	public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ans = null;
        for(int i = 0;i<lists.length;i++) {
        	ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }
	
	public ListNode mergeTwoLists(ListNode a,ListNode b) {
		ListNode ans = new ListNode(0);
		while(a!=null||b!=null) {
			if(a.val<b.val) {
				ans.next = a;
				ans = a;
				a=a.next;
			}else {
				ans.next=b;
				ans=b;
				b=b.next;
			}
		}
		if(a==null) ans.next=b;
		else if(b==null) ans.next=a;
		return ans;
	}
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists==null||lists.length==0) return null;
		return merge(lists,0,lists.length-1);
	}
	
	private ListNode merge(ListNode[] lists,int left,int right) {
		if(left==right)
			return lists[left];
		int mid = left+(right-left)/2;
		ListNode l1 = merge(lists,left,mid);
		ListNode l2 = merge(lists,mid+1,right);
		return mergeTwoLists(l1, l2);
	}

}
