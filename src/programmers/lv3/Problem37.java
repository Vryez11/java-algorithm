package src.programmers.lv3;

import java.util.*;

public class Problem37 {

    int index = 0;

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });

        Node root = nodes[0];

        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }

        int[][] answer = new int[2][n];

        index = 0;
        preorder(root, answer[0]);

        index = 0;
        postorder(root, answer[1]);

        return answer;
    }

    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    private void preorder(Node node, int[] result) {
        if (node == null) {
            return;
        }

        result[index++] = node.num;
        preorder(node.left, result);
        preorder(node.right, result);
    }

    private void postorder(Node node, int[] result) {
        if (node == null) {
            return;
        }

        postorder(node.left, result);
        postorder(node.right, result);
        result[index++] = node.num;
    }

    static class Node {
        int x;
        int y;
        int num;
        Node left;
        Node right;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
