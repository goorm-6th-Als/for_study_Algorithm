package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_1991_트리_순회 {


    static class Node{
        private char value;
        private Node left;
        private Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    static Node[] tree;
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n =parseInt(br.readLine());
        StringTokenizer st;
        tree = new Node[n];
        char parent;
        char leftNode, rightNode;
        tree[0] = new Node('A',null,null);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            parent = st.nextToken().charAt(0);
            leftNode = st.nextToken().charAt(0);
            rightNode = st.nextToken().charAt(0);

            if(leftNode != '.'){
                tree[leftNode - 'A'] = new Node(leftNode, null, null);
                tree[parent - 'A'].setLeft(tree[leftNode - 'A']);
            }
            if(rightNode != '.'){
                tree[rightNode - 'A'] = new Node(rightNode, null, null);
                tree[parent - 'A'].setRight(tree[rightNode - 'A']);
            }


        }
        preorder(tree[0]);
        bw.append("\n");
        inorder(tree[0]);
        bw.append("\n");
        postorder(tree[0]);
        bw.append("\n");
        bw.flush();
        bw.close();
        br.close();

    }
    static void preorder(Node node) throws IOException {
        if(node == null) return;
        bw.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node) throws IOException {
        if(node == null) return;
        inorder(node.left);
        bw.append(node.value);
        inorder(node.right);
    }
    static void postorder(Node node) throws IOException {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        bw.append(node.value);
    }

}
