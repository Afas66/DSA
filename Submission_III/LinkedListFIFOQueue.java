public class LinkedListFIFOQueue {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    Node front = null, rear = null;

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int value = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return value;
    }

    public void display() {
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
