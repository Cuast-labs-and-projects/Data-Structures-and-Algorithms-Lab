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

    public void AddLinkBeg(int data) {
        Link newLink = new Link(data);
        if (first == null) {
            first = newLink;

        }
        newLink.next = first;
        first = newLink;
    }

    public void AddLinkAfter(int ref, int data) {
        if (first == null)
            return;
        Link newLink = new Link(data);
        Link current = first;
        while (current.next != null) {

            if (current.data == ref) {

                newLink.next = current.next;
                current.next = newLink;
                break;
            }
            current = current.next;
        }

    }

    public void Display() {
        Link current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void DeleteLink(int val) {

        Link temp = first, prev = null;

        if (temp != null && temp.data == val) {
            first = temp.next;
            return;
        }

        while (temp != null && temp.data != val) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
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

    public void DeleteLinkBeg() {

        if (first == null)
            return;
        first = first.next;

    }
}

public class LinkedList {
    public static void main(String[] args) {
        char c;
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList llist = new SinglyLinkedList();
        do {

            System.out.println("Choose any operation");
            System.out.println("1. Add to the end");
            System.out.println("2. Add link in the beggining");
            System.out.println("3. Add link after a specific link");
            System.out.println("4. Delete link from beggining");
            System.out.println("5. Delete link from end");
            System.out.println("6. Delete link from a particular position");
            System.out.println("7. Display");
            char ch = scan.next().charAt(0);

            switch (ch) {
            case '1':
                System.out.println("enter a value to add to the linked list");
                int ele = scan.nextInt();
                llist.AddLinkEnd(ele);
                break;
            case '2':
                System.out.println("enter a value to add to the linked list");
                ele = scan.nextInt();
                llist.AddLinkBeg(ele);
                break;
            case '3':
                System.out.println("After which link do you need to add the link");
                int after = scan.nextInt();
                System.out.println("enter a value to add to the linked list");
                ele = scan.nextInt();
                llist.AddLinkAfter(after, ele);
                break;
            case '4':
                llist.DeleteLinkBeg();
                break;

            case '5':
                llist.DeleteLinkEnd();
                break;

            case '6':
                System.out.println("The the value of the node you want to delete");
                ele = scan.nextInt();
                llist.DeleteLink(ele);
                break;

            case '7':
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
