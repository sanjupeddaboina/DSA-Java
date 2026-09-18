class Solution {
    // Function to delete tail of DLL
    public Node deleteTail(Node head) {
        // If list is empty
        if (head == null) return null;

        // If only one node present
        if (head.next == null) return null;

        // Traverse to the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Update second last node's next to null
        temp.prev.next = null;

        // Return head
        return head;
    }
}
