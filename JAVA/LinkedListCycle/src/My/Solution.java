package My;

import java.util.ArrayList;
import java.util.List;

import My.ListNode;
import My.Solution;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
*  Tortoise and Hare Algorithm
If the linked list has a loop they will definitely meet.
Else either of the two references(or their next) will become null.
*/

public class Solution {
	public static boolean hasCycle(ListNode head) {
	   final ListNode first = head;
	   
       List<ListNode> ListNodeList = new ArrayList<ListNode>(){{add(first);}};
       
       if(head == null) return false;

       while(true){
    	   if(head.next == null) return false;
    	   else{
    		   head = head.next;
    		   if(ListNodeList.contains(head)) return true;
    		   ListNodeList.add(head); 
    	   }	   
       }
   }
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = a;
		
		System.out.println("hasCycle:"+Solution.hasCycle(a));
		
		d.next = null;
		
		System.out.println("hasCycle:"+Solution.hasCycle(a));
	}
}
