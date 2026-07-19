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
       
        if (head == null || head.next == null) {
            return true;
        }
       
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;        
            fast = fast.next.next;  
        }
        
        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;
        
        ListNode p1 = firstHalfHead;
        ListNode p2 = secondHalfHead;
        
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next; 
            p2 = p2.next; 
        }
       
        return true;
    }
   
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextNode = curr.next; 
            curr.next = prev;            
            prev = curr;                  
            curr = nextNode;              
        }
        
        return prev; 
    }
}