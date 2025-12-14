public class UnboundedArrayStack {
    private int[] arr;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 == capacity) {
            resize(capacity * 2);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int value = arr[top--];

        if (top + 1 > 0 && top + 1 <= capacity / 4) {
            resize(capacity / 2);
        }
        return value;
    }

    private void resize(int newCapacity) {
        capacity = newCapacity;
        int[] newArr = new int[capacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        System.out.println(stack.pop()); // 2
    }
}
