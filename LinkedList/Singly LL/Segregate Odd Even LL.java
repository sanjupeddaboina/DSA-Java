class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode tempEven = head.next;
        while(evenNode != null && evenNode.next!= null){
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenNode.next = oddNode.next;
            evenNode = oddNode.next;
        }
        oddNode.next = tempEven;
        return head;
    }
}
