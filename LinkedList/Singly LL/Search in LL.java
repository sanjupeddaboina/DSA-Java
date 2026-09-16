class Solution {
    // Function to search for a value in LL
    public boolean searchValue(Node head, int key) {
        Node current = head;

        // Traverse until end
        while (current != null) {
            // Check if current node matches key
            if (current.data == key) {
                // Return true if found
                return true;
            }
            current = current.next;
        }

        // Return false if not found
        return false;
    }
}
