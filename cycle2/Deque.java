import java.util.Scanner;

class Deque {
    static class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
        }
    }

    Node front = null;
    Node rear = null;
    int size = 0;

    void insertFront(int x) {
        Node node = new Node(x);
        if (front == null) {
            front = rear = node;
        } else {
            node.next = front;
            front.prev = node;
            front = node;
        }
        size++;
    }

    private void insertEnd(int x) {
        Node node = new Node(x);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        size++;
    }

    private void deleteFront() {
        if (front == null) {
            return;
        }
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
    }

    private void deleteEnd() {
        if (rear == null) {
            return;
        }
        if (rear == front) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
    }

    private int getFront() {
        if (front != null) {
            return front.data;
        }
        return -1;
    }

    private int getEnd() {
        if (rear != null) {
            return rear.data;
        }
        return -1;
    }

    private boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }

    private int size() {
        return size;
    }

    private void erase() {
        rear = null;
        while (front != null) {
            front.prev = null;
            front = front.next;
        }
        size = 0;
    }

    public static void main(String[] args) {
        char c;
        Scanner scan = new Scanner(System.in);
        Deque llist = new Deque();
        do {

            System.out.println("Choose any operation");
            System.out.println("1. insert to the end");
            System.out.println("2. insert in the beggining");
            System.out.println("3. delete from the beggining");
            System.out.println("4. delete from the end");
            System.out.println("5. Get the front node");
            System.out.println("6. Get the rear node");
            char ch = scan.next().charAt(0);

            switch (ch) {
            case '1':
                System.out.println("enter a value to add to be inserted");
                int ele = scan.nextInt();
                llist.insertEnd(ele);
                break;
            case '2':
                System.out.println("enter a value to add to be inserted");
                ele = scan.nextInt();
                llist.insertFront(ele);
                break;
            case '3':
                llist.deleteFront();
                break;
            case '4':
                llist.deleteEnd();
                break;

            case '5':
                int a = llist.getFront();
                System.out.println("The front node is " + a);
                break;

            case '6':
                int b = llist.getEnd();
                System.out.println("The rear node is " + b);
                break;

            default:
                System.out.println("invalid option");

            }
            System.out.println("Do you want to continue(y/n)");
            c = scan.next().charAt(0);

        } while (c == 'y');

        scan.close();
    }

}
