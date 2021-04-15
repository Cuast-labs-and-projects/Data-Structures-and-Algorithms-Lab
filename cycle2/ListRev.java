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
            System.out.println(current.data);
            current = current.next;
        }
    } 
    public void reverse() {

        Link prev = null;
        Link current = first;

        while(current != null) {
            Link next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        first = prev;
    }
    
}
public class ListRev {

    public static void main(String[] ars) {
        
        Scanner scan = new Scanner(System.in);

        SinglyLinkedList llist = new SinglyLinkedList();

        System.out.println("Enter the no of elements in the linked list");

        int n = scan.nextInt();
        System.out.println("Enter the node values");
        
        while(n > 0) {
            
            int ele = scan.nextInt();
            llist.AddLinkEnd(ele);
            --n;
            
        }
        
        llist.reverse();
        System.out.println("The reversed Linked list is ");
        llist.Display();


    }
        
}
