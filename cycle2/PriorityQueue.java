// Write a java program to implement a descending priority queue using singly linked list.

import java.util.Scanner;
class PriorityQueue
{
	static class Link
	{
		int data;
		Link next;
		public Link(int d)
		{
			data=d;
			next=null;
		}
		public void displayLink()
		{
			System.out.print(data+" ");
		}
	}
	static class linkList
	{
		Link first;
		public linkList()
		{
			first=null;
		}
		public void insertElement(int d)
		{
			Link current=first;
			Link newLink=new Link(d);
			if(first==null)
				first=newLink;
			else if(newLink.data>current.data)
			{
				newLink.next=first;
				first=newLink;
			}	
			else
			{
				
				while(current!=null)
				{
					if(current.next==null)
					{
						current.next=newLink;
						break;	
					}
					else if(newLink.data>current.next.data)
					{
						newLink.next=current.next;
						current.next=newLink;
						break;
					}
					current=current.next;
				}
			}
		}
		public void deleteElement()
		{
			if(first==null)
				System.out.println("Empty Queue!!!");
			else
				first=first.next;
		}
		public void displayElements()
		{
			Link current=first;
			if(first==null)
				System.out.println("Empty Queue!!!");
			else
				while(current!=null)
				{
					current.displayLink();
					current=current.next;
				}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		int c=0,d;
		linkList pQueue=new linkList();
		Scanner scan=new Scanner(System.in);
		while(c!=4)
		{	
			System.out.println("Enter your choice(1-4):");
			System.out.println("1.Enter element");
			System.out.println("2.Delete element");
			System.out.println("3.Display Queue");
			System.out.println("4.Exit");
			c=scan.nextInt();
			switch(c)
			{
				case 1:
					System.out.println("Enter the data");
					d=scan.nextInt();
					pQueue.insertElement(d);
					break;
				case 2:
					pQueue.deleteElement();
					break;
				case 3:
					pQueue.displayElements();
					break;
				case 4:
					break;
				default:
					System.out.println("Error!!!");
					break;
			}
		}
        scan.close();
	}
}