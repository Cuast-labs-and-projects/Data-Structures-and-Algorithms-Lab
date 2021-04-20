import java.util.Scanner;

class CharStack {
    int len;
    char[] body;
    int top = -1;

    CharStack(int len) {
        this.len = len;
        body = new char[len];
    }

    void Push(char a) {
        if (top + 1 < len) {
            top++;
            body[top] = a;
        } else {
            System.out.println("Stack overflow");
        }
    }

    char Pop() {
        if (top >= 0) {
            top--;
            return body[top + 1];
        } else {
            System.out.println("Stack underflow");
            return '\0';
        }
    }
}

public class StringReversal {
    public static void main(String args[]) {
        String inS;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Press Ctrl + C to exit\nEnter String: ");
                inS = sc.next();
                System.out.println(GetReverseString(inS));
            }
        } catch (Exception e) {
            System.out.println("Program exited");
            sc.close();
        }
    }

    public static String GetReverseString(String s) {
        CharStack cs = new CharStack(s.length());
        String revString = "";
        for (int i = 0; i < s.length(); i++) {
            cs.Push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            revString += cs.Pop();
        }
        return revString;
    }
}