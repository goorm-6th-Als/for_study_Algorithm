import java.io.*;
import java.util.*;

class Node {
    String value;
    Node left;
    Node right;

    Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class Main { // Boj_1991_트리 순회


    static int N;
    // 루트는 A로 고정
    static Node head = new Node("A", null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0; tc<N; tc++) {
                st = new StringTokenizer(br.readLine());
                String now = st.nextToken();
                String left = st.nextToken();
                String right = st.nextToken();
                setNode(head, now, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    public static void setNode(Node head, String root, String left, String right) {
        if (head.value.equals(root)) { // 처음 나온 알파뱃이면 새로 만들기.
            head.left = (left.equals(".")) ? null : new Node(left, null, null);
            head.right = (right.equals(".")) ? null : new Node(right, null, null);
        } else {
            if (head.left != null) {
                setNode(head.left, root, left, right);
            }
            if (head.right != null) {
                setNode(head.right, root, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    public static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}
