// Insert a node at head

class Solution {
    // Function to insert a new node at the head
    public Node insertAtHead(Node head, int newData) {
        // Create a new node whose next points to current head
        Node newNode = new Node(newData);
        newNode.next = head;
        // Return the new node as the head
        return newNode;
    }
}
