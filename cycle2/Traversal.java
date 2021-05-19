import java.util.Scanner;
class Node {
    Node lchild;
    Node rchild;
    int val;

    Node(int item) {
        this.val = item;
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
    }

    void printInorder(Node node) {

        if (node == null) {
            return;
        }

        printInorder(node.lchild);
        System.out.println(node.val);
        printInorder(node.rchild);

    }

    void preorder() {
        printPreorder(root);
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);

        printPreorder(node.lchild);
        printPreorder(node.rchild);
    }

    void PostOrder() {
        PrintPostorder(root);
    }

    void PrintPostorder(Node node) {
        if (node == null) {
            return;
        }

        PrintPostorder(node.lchild);
        PrintPostorder(node.rchild);
        System.out.println(node.val);

    }

}

class Traversal{
     
     public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       BinarySearchTree BST = new BinarySearchTree();
       System.out.println("Enter the number of elements you need to insert into the binary search tree");
       int n = scan.nextInt();
       System.out.println("Enter the elements to be inserted into the tree");
       while(n != 0) {
           int ele = scan.nextInt();
           BST.insert(ele);
           n = n-1;

       }
       System.out.println("The inorder Traversal of the tree");
       BST.inorder();
       System.out.println("The preorder Traversal of the tree");
       BST.preorder();
       System.out.println("The postorder Traversal of the tree");
       BST.PostOrder();
       scan.close();
    }
}