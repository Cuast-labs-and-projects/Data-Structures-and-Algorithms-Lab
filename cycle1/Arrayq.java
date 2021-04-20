import java.util.*;
 
class arrayQueue
{
    protected int Queue[];
    protected int front, rear, size, len;
 
    public arrayQueue(int n) 
    {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }    
    
    public boolean isEmpty() 
    {
        return front == -1;
    }    
    
    public boolean isFull() 
    {
        return front==0 && rear==size-1;
    }    

    public int getSize()
    {
        return len;
    }    

    public int peek() 
    {
        if (isEmpty())
           System.out.println("**Underflow**");
        return Queue[front];
    }    

    public void insert(int i) 
    {
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
            System.out.println("**Overflow**");
        else if ( rear + 1 < size)
            Queue[++rear] = i;    
        len++ ;    
    }    

    public int remove() 
    {
        if (isEmpty())
        {
           System.out.println("**Underflow**");
           return -1;
        }
        else 
        {
            len-- ;
            int ele = Queue[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                front++;                
            return ele;
        }        
    }

    public void display()
    {
        System.out.println("\nQueue = ");
        if (len == 0)
        {
            System.out.println("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.println(Queue[i]+" ");
        System.out.println();        
    }
}
 
public class Arrayq
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("**IMPLEMENTATION OF QUEUE OPERATIONS**\n");
        System.out.println("Enter Size of Integer Queue : ");
        int n = scan.nextInt();
        arrayQueue q = new arrayQueue(n);                
        char ch;
        do{
            System.out.println("\nQueue Operations");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                q.insert( scan.nextInt() );                     
                break;                         
            case 2 : 
                System.out.println("Removed Element = "+q.remove());
                break;                         
            case 3 :
                q.display();                         
            }            
            System.out.println("Do you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                                                        
    }    
}