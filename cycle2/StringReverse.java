import java.util.*;

class Stack {
    int size;
    int top;
    char[] a ;

    boolean isEmpty(){
        return (top < 0);
    }

    Stack(int n) {
        size = n ;
        top = -1;
        a = new char[size];
    }

    void push(char x) {

        if (top >= size){
            System.out.println("Stack Overflow");
        }
        else {
            a[++top] = x;
        }
    }
    char pop() {
        if (top < 0) {
            System.out.println("stack Underflow");
            return 0;
        }
        else {
            char x = a[top--];
            return x;
        }
    }


}

class StringReverse {

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Enter a string to reverse");
        String str = scan.nextLine();
        int n = str.length();
        String new_str = ""; 
        Stack obj = new Stack(n);

        for (int i = 0 ; i < n ;i++) {
            obj.push(str.charAt(i));
        }

        for (int i = 0 ; i < n ; i++) {
            char ch = obj.pop();
            new_str += ch;
        }

        System.out.println("The Reversed String is  " + new_str);
        scan.close();
    }
}
