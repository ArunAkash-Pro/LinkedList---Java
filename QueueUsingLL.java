class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}
class Queue {
    Node front;
    Node rear;
    int size;
    Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    int dequeue() {
        if (front == null)  return -1;
        int data = front.data;
        front = front.next;
        if (front == null)  rear = null;
        size--;
        return data;
    }

    int peek() {
        if (front == null)  return -1;
        return front.data;
    }

    void display() {
        if (front == null)  return;
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp  = temp.next;
        }
        System.out.println();
    }
}
public class QueueUsingLL {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(7);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.display();
    }
}
