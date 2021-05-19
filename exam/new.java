import java.io.*;
import java.util.Scanner;

public class DescendingPriorityQueue 
{
    static class Node 
    {
        int data;
        int priority;
        Node next;

        public Node(int data, int priority) 
        {
            this.data = data;
            this.priority = priority;
        }
    }


    private static Node head = null;

    private static void push(int x, int p) 
    {
        Node newNode = new Node(x, p);
        if (head == null) 
        {
            head = newNode;
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null && temp.priority > p) 
        {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) 
        {
            prev.next = newNode;
        } 
        else 
        {
            if (prev == null) 
            {
                newNode.next = head;
                head = newNode;
            } 
            else 
            {
                newNode.next = temp;
                prev.next = newNode;
            }
        }
    }
    
     static boolean  IsEmpty()
    {
      return head == null;
    }

    private static int peek() 
    {
        if (head != null) 
        {
            return head.data;
        }
        return Integer.MIN_VALUE;
    }

    private static int pop() 
    {
        if (head != null) 
        {
            int data = head.data;
            head = head.next;
            return data;
        }
        return Integer.MIN_VALUE;
    }

    public static void Display() 
    {
        Node current = head;
        if (IsEmpty()) 
        {
            System.out.println("Empty");
        } 
        else 
        {
            while (current != null) 
            {
                System.out.print("(" + current.data + ", " + current.priority + ") ");
                current = current.next;
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        char ch;
        do 
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. Add a value");
            System.out.println("2. Remove a value");
            System.out.println("3. Peek");
    
            int choice = scan.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter integer element to insert and then the priority");
                    int data = scan.nextInt();
                    int priority = scan.nextInt();
                    push(data, priority);
                    break;
                case 2:
                    int popped = pop();
                    if (popped == Integer.MIN_VALUE) 
                    {
                        System.out.println("Empty");
                    } else 
                    {
                        System.out.println("Removed Element = " + popped);
                    }
                    break;
                case 3:
                    int peeked = peek();
                    if (peeked == Integer.MIN_VALUE) 
                    {
                        System.out.println("Empty");
                    } 
                    else 
                    {
                        System.out.println("Front Element = " + peeked);
                    }
                    break;
                default:
                    System.out.println("Invalid input");
            }
            Display();
            System.out.println("Do you want to continue (Type y or n) ");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
        scan.close();
    }
}
