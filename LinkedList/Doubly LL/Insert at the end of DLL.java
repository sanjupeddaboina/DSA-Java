class Solution { 
   public static Node insertAtTail(Node head, int k) {
           // Create a new node with data 'k'
      Node newNode = new Node(k);
  
      // If the list is empty, return the new node as the head
      if (head == null) {
          return newNode;
      }
  
      // Traverse to the last node of the doubly linked list
      Node tail = head;
      while (tail.next != null) {
          tail = tail.next;
      }
  
      // Connect the new node to the last node
      tail.next = newNode;
      newNode.back = tail;  // Set the 'back' pointer of the new node to the previous node
      return head;  // Return the head of the modified list
   }
}
