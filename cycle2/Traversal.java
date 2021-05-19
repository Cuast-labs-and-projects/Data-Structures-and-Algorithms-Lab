import java.util.Scanner;
class Node {
    Node lchild;
    Node rchild;
    int val;

    Node(int item) {
        this.val = item;
    }

}
class QNode {
    Node key;
    QNode next;
    public QNode(Node key)
    {
        this.key = key;
        this.next = null;
    }
}
  
class Queue {
    QNode front, rear;
  
    public Queue()
    {
        this.front = this.rear = null;
    }
  
    void enqueue(Node key)
    {
  
        QNode temp = new QNode(key);
  
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
  
        this.rear.next = temp;
        this.rear = temp;
    }
  
    Node dequeue()
    {
        if (this.front == null)
            return null;
  
        QNode temp = this.front;
        this.front = this.front.next;
  
        if (this.front == null)
            this.rear = null;
        

        return temp.key;
    }
    public boolean isEmpty()
    {
        return front == null;
    }  
}
  
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        this.root = null;
    }

    void insert(int val) {
        this.root = insertBST(root, val);
    }

    Node insertBST(Node node, int val) {

        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.lchild =  insertBST(node.lchild, val);
        } 
        else if (val >= node.val) {
            node.rchild = insertBST(node.rchild, val);
        }

        return node;

    }

    void inorder() {
        printInorder(root);
        System.out.print('\n');
    }

    void printInorder(Node node) {

        if (node == null) {
            return;
        }

        printInorder(node.lchild);
        System.out.print(node.val+" ");
        printInorder(node.rchild);

    }

    void preorder() {
        printPreorder(root);
        System.out.print('\n');
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val+" ");

        printPreorder(node.lchild);
        printPreorder(node.rchild);
    }

    void PostOrder() {
        PrintPostorder(root);
        System.out.print('\n');
    }

    void PrintPostorder(Node node) {
        if (node == null) {
            return;
        }

        PrintPostorder(node.lchild);
        PrintPostorder(node.rchild);
        System.out.print(node.val + " ");

    }
    void Dfs (int ele) {
       if(DfsHelper(root, ele)){
           System.out.println("Element found via DFS");
       }
       else{
           System.out.println("Element not found via DFS");
           
       }
    }
    boolean DfsHelper(Node node , int ele){
        while(node != null){
            if(node.val > ele){
                node = node.lchild;
            }
            else if(node.val < ele){
                node = node.rchild;
            }
            else{
                return true;
            }
        }
        return false;
    }
    void bfs(int ele){
       if(bfs_helper(root, ele)){
           System.out.println("Element found via BFS");
       }
       else{
           System.out.println("Element not found via BFS");
           
       }
        

    }
    Boolean bfs_helper(Node root , int ele) {
		Queue q = new  Queue();
		if (root == null)
			return false;
		q.enqueue(root);
		while (!q.isEmpty()) {
			Node n = q.dequeue();
			// System.out.print(" " + n.val);
            if (n.val == ele){
                return true;
            }
			if (n.lchild != null)
				q.enqueue(n.lchild);
			if (n.rchild != null)
				q.enqueue(n.rchild);
		}
        return false;
	}

}

class Traversal{
     
     public static void main(String[] args) {
        char c;
        Scanner scan = new Scanner(System.in);
        BinarySearchTree BST = new BinarySearchTree();
        do {

            System.out.println("Choose any operation");
            System.out.println("1. Insert into tree");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. BFS");
            System.out.println("6. DFS");
            char ch = scan.next().charAt(0);

            switch (ch) {
            case '1':
                System.out.println("enter a value to add into the BST");
                int ele = scan.nextInt();
                BST.insert(ele);
                break;
            case '2':
                System.out.println("Inorder Traversal of Linked List");
                BST.inorder();
                break;
            case '3':
                System.out.println("Preorder Traversal of Linked List");
                BST.preorder();
                break;
            case '4':
                System.out.println("Postorder Traversal of Linked List");
                BST.PostOrder();
                break;
            case '5':
                System.out.println("Enter the element to search for");
                int item = scan.nextInt();
                BST.bfs(item);
                break;

            case '6':
                System.out.println("Enter the element to search for");
                item = scan.nextInt();
                BST.Dfs(item);
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
