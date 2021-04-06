import java.util.Scanner;
class Queue {
    int size, front, rear;
    int arr[];

    Queue(int size) {
        this.size = size;
        arr = new int[size];
        front = rear = -1;

    }

    boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    public void enqueue(int val) {

       if (isFull()) {
           System.out.println("Queue is full");
           return ;
       } 
       if (isEmpty()){
           front = 0;
       }
       arr[++rear] = val;
    }
    
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return  -1;
        }
        int ele = arr[front];
        if(front >= rear) {
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }

        return ele;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
          }

        int temp = front;
        while(temp <= rear){
           System.out.println(arr[temp]);
           temp++;
        }
    }

}

public class ArrayQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Stack Enter the size of the Stack");
        int n = sc.nextInt();
        Queue stk = new Queue(n);
        char ch;

        do {

            System.out.println("\n Choose any Stack Operations");
            System.out.println("1. Enqueue ");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter element to add ");

                    stk.enqueue(sc.nextInt());
                    break;

                case 2:
                    System.out.println(stk.dequeue());
                    
                    break;

                case 3:
                    stk.display();
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;

            }
            
            System.out.println("\nDo you want to continue (Type y or n) \n") ;
            ch = sc.next().charAt(0);

        }while(ch == 'y' || ch == 'Y');

        sc.close();
    }


}
