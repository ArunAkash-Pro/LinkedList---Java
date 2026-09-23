class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}
class Stack {
    Node top = null;

    void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null)    return -1;
        int temp = top.data;
        top = top.next;
        return temp;
    }

    int peek() {
        if (top == null)    return -1;
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
    
    void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
public class StackUsingLL {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.peek());

        st.display();
    }
}
