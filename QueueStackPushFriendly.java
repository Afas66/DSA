import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    private Queue<Integer> queue = new LinkedList<>();

    // Push friendly: O(1)
    public void push(int x) {
        queue.add(x);
    }

    // Pop costly: O(n)
    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
        int top = queue.peek();
        queue.add(queue.remove());
        return top;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop()); // 30
    }
}
