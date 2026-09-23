class Node {
    int data;
    Node next;
    Node back;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}
public class DLL {
    private static Node createLLFromArray(int[] arr) {
        if (arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    private static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    private static Node removeHead(Node head) {
        if (head == null || head.next == null)
            return null;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }
    private static Node removeTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }
    private static Node removeNodeAtPos(Node head, int pos) {
        if (head == null)
            return null;
        if (pos == 0)
            return removeHead(head);
        Node curr = head;
        for(int i=0; i<pos && curr!=null; i++)
            curr = curr.next;
        if (curr == null)
            return head;
        curr.back.next = curr.next;
        if (curr.next != null)
            curr.next.back = curr.back;
        curr.back = null;
        curr.next = null;
        return head;
    }
    private static Node deleteNode(Node head, int key) {
        if (head == null)   return null;
        Node curr = head;
        while(curr!=null && curr.data != key)
            curr = curr.next;
        if (curr == null)   return head;
        if (curr == head)   return removeHead(head);
        curr.back.next = curr.next;
        if (curr.next != null)
            curr.next.back = curr.back;
        curr.back = null;
        curr.next = null;
        return head;
    }
    private static Node insertBeforeHead(Node head, int val) {
        if (head == null)
        {
            Node newNode = new Node(val);
            return newNode;
        }
        Node newNode = new Node(val, head, null);
        head.back = newNode;
        return newNode;
    }
    private static Node insertBeforeTail(Node head, int val) {
        if (head.next == null)
            return insertBeforeHead(head, val);
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;
        return head;
    }
    private static Node insertNodeAtPos(Node head, int val, int pos) {
        if (pos < 0)    return head;
        Node newNode = new Node(val);
        if (pos == 0)   return insertBeforeHead(head, val);
        Node curr = head;
        for(int i=0; curr!=null && i<pos-1; i++)
            curr = curr.next;
        if (curr == null)   return head;
        newNode.back = curr;
        newNode.next = curr.next;
        if (curr.next != null)
            curr.next.back = newNode;
        curr.next = newNode;
        return head;
    }
    private static Node insertNode(Node node, int val) {
        if (node.back == null)  
            return insertBeforeHead(node, val);
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
        return node;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        Node head = createLLFromArray(arr);
        Node ans = insertNode(head.next.next.next, 50);
        printLL(head);
        printLL(ans);
    }
}
