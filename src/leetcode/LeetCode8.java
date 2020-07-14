package leetcode;

import java.util.LinkedList;

/**
 * @author zyh
 * @date 2020/7/8
 */
public class LeetCode8 {
    public static void main(String[] args) {
        LeetCode8 l8 = new LeetCode8();
        LinkedList<ListNode> link = new LinkedList<>();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        link.add(n1);
        link.add(n2);
        link.add(n3);
        link.add(n4);

        link.forEach(s -> System.out.println(s.val));
        l8.deleteNode(n2);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
