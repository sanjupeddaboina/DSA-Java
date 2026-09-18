class Solution {

    public Node reverseDLL(Node head) {

        // Pointer to traverse the list
        Node current = head;
        // Variable to eventually store new head after reversal
        Node last = null;

        // Traverse the entire list
        while (current != null) {

            // Swap next and back pointers of current node
            Node temp = current.next;
            current.next = current.back;
            current.back = temp;
            // Move last pointer to current (this will become new head)
            last = current;
            // Move to next node (originally current.next but now is back due to swap)
            current = temp;
        }

        return last;
    }
}
