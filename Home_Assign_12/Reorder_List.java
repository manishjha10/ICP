/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode rev(ListNode head)
    {
        if(head == null || head.next == null) return head ; 
        
        ListNode newHead = rev(head.next) ;
        head.next.next = head ;
        head.next= null ;
        return newHead ;
    }
    public void reorderList(ListNode head) {
        ListNode slow =  head ;
        ListNode fast  = head  ;
       
       while(fast.next != null &&  fast.next.next != null)
       {
           slow  = slow.next ;
           fast = fast.next.next ;
       } 
       ListNode second = rev(slow.next) ;
       slow.next = null ;
       
       ListNode first  = head ;
       
       while(second != null)
       {
           ListNode tmp1 = first.next ;
           ListNode tmp2 = second.next; 
           
           first.next = second ;
           second.next=  tmp1 ;
           
           first = tmp1 ;
           second = tmp2 ;
    }
}
}
