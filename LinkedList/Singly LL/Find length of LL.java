class Solution {
    // Function to find the length of the linked list
    public int lengthOfLinkedList(Node head) {
        int count = 0;
        Node temp = head;
      
        // Traverse the linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // Return the total count
        return count;
    }
}
