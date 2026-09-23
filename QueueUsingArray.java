class Queue {
    int[] arr;
    int front;
    int rear;
    int capacity;
    int size;

    Queue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int val) {
        if (size == capacity)   return;
        rear = (rear + 1) % capacity;
        // if (front == -1)
        //     front = rear;
        arr[rear] = val;
        size++;
    }

    int dequeue() {
        if (front == -1)    return -1;
        int temp = arr[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    int peek() 
    {
        if (size == 0)    return -1;
        return arr[front];
    }

    void display() {
        if (size == 0)  return;
        for(int i=0; i<size; i++)
        {
            int temp = (front + i) % capacity;
            System.out.print(arr[temp] + " ");
        }
        System.out.println();
    }
}
public class QueueUsingArray {
    public static void main(String args[]) {
        Queue q = new Queue(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println(q.dequeue());
        System.out.println(q.peek());

        q.display();
    }
}
