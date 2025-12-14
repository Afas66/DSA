import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push costly: O(n)
    public void push(int x) {
        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop friendly: O(1)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        System.out.println(stack.pop()); // 25
    }
}
