import java.util.Scanner;
import java.util.NoSuchElementException;

class stack {

    private int arr[];

    private int top;

    private int size;

    public stack(int n) {

        size = n;
        top = -1;
        arr = new int[size];

    }

    public boolean isEmpty() {

        return top == -1;

    }

    public boolean isFull() {

        return top == -1;

    }

    public int peek() {

        if (isEmpty()) {

            throw new NoSuchElementException("Underflow Exception");

        }
        return arr[top];

    }

    public void push(int ele) {

        if (top + 1 >= size) {

            throw new IndexOutOfBoundsException("Overflow Exception");

        } else {

            arr[++top] = ele;

        }
    }

    public int pop() {

        if (isEmpty()) {

            throw new NoSuchElementException("Overflow Exception");

        }
        return arr[top--];

    }

    public void display() {

        System.out.print("\nStack = ");
        if (arr.length == 0) {

            System.out.print("Empty\n");
            return;

        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();

    }

}

public class arrayStack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Stack Enter the size of the stack");
        int n = sc.nextInt();
        stack stk = new stack(n);
        char ch;

        do {

            System.out.println("\n Choose any Stack Operations");
            System.out.println("1. Push ");
            System.out.println("2. Pop ");
            System.out.println("3. Peek ");
            System.out.println("4. check empty");
            System.out.println("5. check limit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter element to push ");
                    try {

                        stk.push(sc.nextInt());
                    } catch (Exception e) {

                        System.out.println("Error :" + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Popped Element = " + stk.pop());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Peek Element = " + stk.peek());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Empty status = " + stk.isEmpty());
                    break;
                case 5:
                    System.out.println("Full status = " + stk.isFull());
                    break;

                default:
                    System.out.println("Wrong Entry \n ");
                    break;

            }
            stk.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);
            
        } while (ch == 'Y' || ch == 'y');

        sc.close();
    }

}
