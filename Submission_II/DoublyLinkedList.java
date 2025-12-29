public class DoublyLinkedList {

    class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
        }
    }

    Node head;

    public void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void delete(int key) {
        Node temp = head;

        while (temp != null && temp.data != key)
            temp = temp.next;

        if (temp == null) return;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }

    public void display() {
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.display();
        list.delete(20);
        list.display();
    }
}

