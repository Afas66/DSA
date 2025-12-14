import java.util.Stack;

public class StackQueueEnqueueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue friendly: O(1)
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue costly: O(n)
    public int dequeue() {
        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int front = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return front;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println(queue.dequeue()); // 100
    }
}
