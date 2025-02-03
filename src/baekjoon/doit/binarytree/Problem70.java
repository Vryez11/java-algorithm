package src.baekjoon.doit.binarytree;

import java.io.*;
import java.util.*;

public class Problem70 {

    static Map<String, Node> tree = new HashMap<>();
    static StringBuilder preOrderResult = new StringBuilder();
    static StringBuilder inOrderResult = new StringBuilder();
    static StringBuilder postOrderResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 루트 노드 생성
        tree.put("A", new Node("A"));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            Node parentNode = tree.get(parent);
            if (parentNode == null) continue;

            // 왼쪽 자식 추가
            if (!leftChild.equals(".")) {
                parentNode.left = new Node(leftChild);
                tree.put(leftChild, parentNode.left);
            }

            // 오른쪽 자식 추가
            if (!rightChild.equals(".")) {
                parentNode.right = new Node(rightChild);
                tree.put(rightChild, parentNode.right);
            }
        }
        br.close();

        // 순회 실행
        preOrder(tree.get("A"));
        inOrder(tree.get("A"));
        postOrder(tree.get("A"));

        System.out.println(preOrderResult.toString());
        System.out.println(inOrderResult.toString());
        System.out.println(postOrderResult.toString());
    }

    private static void preOrder(Node node) {
        if (node != null) {
            preOrderResult.append(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inOrderResult.append(node.value);
            inOrder(node.right);
        }
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            postOrderResult.append(node.value);
        }
    }

    static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }
    }

}










