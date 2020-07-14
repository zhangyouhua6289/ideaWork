package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zyh
 * @date 2020/6/12
 */
public class DiguiDemo2 {
    static Deque<Node> deque = new ArrayDeque<>();
    static Set<Node> visited = new HashSet<>();

    static class Node {
        Node left;
        Node right;
        Node up;
        Node down;
        int var;

        public Node(int var) {
            this.var = var;
        }

        @Override
        public String toString() {
            return "var{" + var + '}';
        }
    }

    public static void main(String[] args) {
        Node n00 = new Node(0);
        Node n01 = new Node(1);
        Node n10 = new Node(2);
        Node n11 = new Node(3);
        // 2X2����
        n00.down = n10;
        n00.right = n01;
        n01.left = n00;
        n01.down = n11;
        n10.up = n00;
        n10.right = n11;
        n11.up = n01;
        n11.left = n10;

        digui(n00, 1);
    }

    public static void digui(Node n00, int updownFlag) {

        Node cur = n00;
        System.out.println(cur);
        // ���һ��
        if (cur.right == null) {
            // ���һ�б����Ƿ����
            if ((updownFlag == 1 && cur.down == null) || (updownFlag == 0 && cur.up == null)) {
                return;
            }
        }
        if (updownFlag == 1) {
            if (cur.down != null) {
                digui(cur.down, 1);
            } else {
                digui(cur.right, 0);
            }
        } else if (updownFlag == 0) {
            if (cur.up != null) {
                digui(cur.up, 0);
            } else {
                digui(cur.right, 1);
            }
        }
    }
}
