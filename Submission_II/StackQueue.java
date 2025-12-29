import java.util.Stack;

public class StackQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue operation (O(1) amortized)
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return s2.pop();
    }

    // Display queue
    public void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue Elements: ");

        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.display();
    }
}

