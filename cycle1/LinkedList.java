import java.util.Scanner;
class Link {
    int data;
    Link next;

    public Link (int data){
        this.data = data;
        this.next = null;

    }
}

class SinglyLinkedList {
    Link first = null;

    public void AddLink(int data) {
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


    public void DeleteLink(int val) {
        if (first == null) return;
        else if (first.next == null && val ==first.data){
            first = null;
            return;
        }
        Link start = first;
        while(start.next != null) {
            if(start.next.data == val) {
                Link curr = start.next;
                start.next = curr.next;
                return;
            }
            start = start.next;

        }
    }
}
public class LinkedList {
    public static void main(String[] args) {
    char c;
    Scanner scan = new Scanner(System.in);
    SinglyLinkedList llist = new SinglyLinkedList();
    do {

    
       System.out.println("Choose any operation"); 
       System.out.println("1. Addlink"); 
       System.out.println("2. Delete link"); 
       System.out.println("3. Display"); 
       char ch = scan.next().charAt(0);
       
       switch(ch){
           case '1': System.out.println("enter a value to add to the linked list");
                     int ele = scan.nextInt();
                     llist.AddLink(ele) ;
                     break; 
           case '2': System.out.println("The the value of the node you want to delete");
                     ele = scan.nextInt();
                     llist.DeleteLink(ele);
                     break;
          
           case '3': llist.Display();
                     break;
           
           default:  System.out.println("invalid option");

        }
        System.out.println("Do you want to continue(y/n)");
        c = scan.next().charAt(0);

     }while(c == 'y');
        

    scan.close();   
    }
    
}
