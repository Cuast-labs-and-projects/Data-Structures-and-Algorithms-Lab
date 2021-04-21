// program no 5
// program to convert infix expression to postfix and prefix expression

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Stack {
    int size;
    int top;
    char[] a;

    boolean isEmpty() {
        return (top < 0);
    }

    Stack(int n) {
        size = n;
        top = -1;
        a = new char[size];
    }

    void push(char x) {

        if (top >= size) {
            System.out.println("Stack Overflow");
        } else {
            a[++top] = x;
        }
    }

    char pop() {
        if (top < 0) {

            return 0;
        } else {
            char x = a[top--];
            return x;
        }
    }

    char peek() {

        char x = a[top];
        return x;

    }

}

class Infix {
    static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'Z'));
    }

    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {

        String result = new String("");

        Stack stack = new Stack(exp.length());

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {

                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    static StringBuilder infixToPrefix(String infix) {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(infix);
        input.reverse();
        Stack stack = new Stack(infix.length());

        char[] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            } else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i < charsExp.length; i++) {
            char c = charsExp[i];

            if (Prec(c) > 0) {
                while (stack.isEmpty() == false && Prec(stack.peek()) >= Prec(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result.append(x);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {

                result.append(c);
            }
        }

        for (int i = 0; i <= stack.size; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

    public static void main(String[] args) throws Exception {
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input string");
        s = br.readLine();
        System.out.println("Postfix form is " + infixToPostfix(s));
        System.out.println("Prefix form is " + infixToPrefix(s));
    }
}
