class Stack {
    int[] arr;
    int top;
    Stack(int size) {
        arr = new int[size];
        top = -1;
    }
    void push(int value) {
        if (top == arr.length-1)    //Stack Overflow
            return;
        top++;
        arr[top] = value;
    }
    int pop() {
        if (top == -1)  //Stack Underflow
            return -1;
        int val = arr[top];
        top--;
        return val;
    }
    int peek() {
        if (top == -1)
            return -1;
        return arr[top];
    }
    boolean isEmpty() {
        return top == -1;
    }
    int size() {
        return top+1;
    }
}
public class StackusingArray {
    public static void main(String args[]) {
        Stack st = new Stack(10);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
        System.out.println(st.size());
    }
}
