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
    public boolean isPalindrome(ListNode head) {
        //  1)  middle find leaft and after lest middle reveerse it and check 
         if(head == null){
            return false  ;
         }
        ListNode temp2 = head ;
        ListNode slow  =  head;
        ListNode fast  = head ;
        
        while(  fast.next != null && fast.next.next != null){
            slow  =  slow.next ;
            fast =  fast.next.next ;
        }
        ListNode curr = slow.next ; 
        ListNode temp =  slow ;
        ListNode pre  = null ;
        ListNode agla = null ;
        while(curr != null){
           agla = curr.next ;
           curr.next  = pre  ;
           pre = curr ;
           curr = agla ;
        }
        ListNode temp1 =  pre  ; 
        temp.next  = temp1 ;

        while(temp1 != null){
           if(temp2.val == temp1.val){
            temp2 = temp2.next ;
            temp1 = temp1.next ;
           }
           else{
            return false  ;
           }
        }

        return true  ;
    }
}
