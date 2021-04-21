import java.util.Scanner;

class Link {
    int data;
    Link next;

    public Link(int data) {
        this.data = data;
        this.next = null;

    }
}

class SinglyLinkedList {
    Link first = null;

    public void AddLinkEnd(int data) {
        Link newLink = new Link(data);
        Link current = first;
        if (current == null) {
            first = newLink;
        } else {
            while (current != null) {
                if (current.next == null) {
                    current.next = newLink;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
    }




    public void Display() {
        Link current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }

    public void deleteMid()
    {

        if (first == null)
            return ;
        if (first.next == null) {
            return ;
        }
 
        Link slow_ptr = first;
        Link fast_ptr = first;
 
        Link prev = null;

        while (fast_ptr != null
                  && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }
 

        prev.next = slow_ptr.next;
 
    }

    public void DeleteLinkEnd() {
        if (first == null)
            return;

        Link current = first;
        while (current.next.next != null) {
            current = current.next;

        }
        current.next = null;

        

    }

}

public class LinkedList {
    public static void main(String[] args) {
        char c;
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList llist = new SinglyLinkedList();
        do {

            System.out.println("Choose any operation");
            System.out.println("1. Add to Linked List");
            System.out.println("2. Delete link from end");
            System.out.println("3. Delete link in the middle position");
            System.out.println("4. Display");
            char ch = scan.next().charAt(0);

            switch (ch) {
            case '1':
                System.out.println("enter a value to add to the linked list");
                int ele = scan.nextInt();
                llist.AddLinkEnd(ele);
                break;

            case '2':
                llist.DeleteLinkEnd();
                break;

            case '3':
                llist.deleteMid();
                break;

            case '4':
                llist.Display();
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
