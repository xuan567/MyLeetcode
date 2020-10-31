package com.problem;
/*
 * 	���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5],
 *  skipA = 2, skipB = 3
	�����Reference of the node with value = 8
	������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬������������ཻ����Ϊ 0����
	�Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]��
	�� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
 * Definition for singly-linked list.
 */

public class leetcode_160 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null||headB==null) {
    		return null;
    	}
    	ListNode pa,pb;
    	pa=headA;
    	pb=headB;
    	
    	while(pa!=pb) {
    		pa=(pa==null)?headB:pa.next;
    		pb=(pb==null)?headA:pb.next;
    	}
    	return pa;
    }

}
