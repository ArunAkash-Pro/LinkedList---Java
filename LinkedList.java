class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    private static Node createLLFromArray(int arr[]) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            curr.next = temp;
            curr = temp;
        }
        return head;
    }
    private static void printLL(Node head) {
        Node curr = head;
        while(curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    private static int lengthOfLL(Node head) {
        int length = 0;
        Node curr = head;
        while(curr != null)
        {
            length++;
            curr = curr.next;
        }
        return length;
    }
    private static boolean searchInLL(Node head, int key) {
        Node curr = head;
        while(curr != null)
        {
            if (curr.data == key)
                    return true;
            curr = curr.next;
        }
        return false;
    }
    private static Node deleteHead(Node head) {
        if (head == null)
            return null;
        head = head.next;
        return head;
    }
    private static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node curr = head;
        while(curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }
    private static Node deleteNodeAtPos(Node head, int pos) {
        if (head == null)
            return null;
        if (pos == 0)
            return deleteHead(head);
        Node curr = head;
        for(int i=0; curr!=null && i<pos-1; i++)
            curr = curr.next;
        if (curr == null || curr.next == null)
            return head;
        curr.next = curr.next.next;
        return head;
    }
    private static Node deleteNode(Node head, int key) {
        if (head == null)   return null;
        if (head.data == key)   return deleteHead(head);
        Node curr = head;
        while(curr != null) {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }
    private static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        newNode.next = head;
        return newNode;
    }
    private static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        return head;
    }
    private static Node insertAtPos(Node head, int data, int pos) {
        if (head == null || pos == 0)
            return insertAtHead(head, data);
        Node newNode = new Node(data);
        Node curr = head;
        for(int i=0; curr!=null && i<pos-1; i++)
            curr = curr.next;
        if (curr == null)
            return head;
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
    private static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }
        return prev;
    }
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        Node head = createLLFromArray(arr);
        System.out.println("Length of LL: " + lengthOfLL(head));
        System.out.println(searchInLL(head, 30));
    }
}
