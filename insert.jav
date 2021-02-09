static void printAlternateLink( Link head)  
{  
    int count = 0;  
  
    while (head != null) 
    {  
  
        // when count is even print the Links  
        if (count % 2 == 0)  
            System.out.printf(" %d ", head.data);  
  
        // count the Links  
        count++;  
  
        // move on the next Link.  
        head = head.next;  
    }  
} 