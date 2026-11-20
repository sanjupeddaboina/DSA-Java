/* Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode dummyNode = new ListNode(-1), dummyTemp = dummyNode;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null) sum += temp1.val;
            if(temp2 != null) sum += temp2.val;
            if(sum < 10){
                ListNode nn = new ListNode(sum);
                dummyTemp.next = nn;
                dummyTemp = dummyTemp.next;
                carry = 0;
            }else{
                ListNode nn = new ListNode(sum % 10);
                dummyTemp.next = nn;
                dummyTemp = dummyTemp.next;
                carry = sum / 10;
            }
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(carry == 1){
            ListNode nn = new ListNode(1);
            dummyTemp.next = nn;
        }
        return dummyNode.next;
    }
}
