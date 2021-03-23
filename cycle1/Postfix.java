// Experiment 6
// program to evaluate postfix expression

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Stack {
    int size;
    int top;
    int[] a;

    boolean isEmpty() {
        return (top < 0);
    }

    Stack(int n) {
        size = n;
        top = -1;
        a = new int[size];
    }

    void push(int x) {

        if (top >= size) {
            System.out.println("Stack Overflow");
        } else {
            a[++top] = x;
        }
    }

    int pop() {
        if (top < 0) {

            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    int peek() {

        int x = a[top];
        return x;

    }

}
public class Postfix {

    static int evaluatePostfix(String exp){

        Stack stack = new Stack(exp.length());
        
        for(int i = 0 ; i < exp.length(); i++){

            char c = exp.charAt(i);

            if(Character.isDigit(c)){
                int n = Character.getNumericValue(c);
                stack.push(n);
            }
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                  
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                      
                    case '-':
                    stack.push(val2- val1);
                    break;
                      
                    case '/':
                    stack.push(val2/val1);
                    break;
                      
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();

    }
    public static void main(String[] args)throws Exception {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the input string");
        s = br.readLine() ;
        System.out.println("postfix evaluation is : "+evaluatePostfix(s));

    }
}
