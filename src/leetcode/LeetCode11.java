package leetcode;

/**
 * @author zhangyouhua
 * @date 2020/8/25 7:44
 */
public class LeetCode11 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;
        ListNode l3 = new ListNode(0);
        ListNode l3_cur = null;
        int count1 = 0;
        int count2 = 0;

        while (l1_cur != null) // 判断L1位数
        {
            count1++;
            l1_cur = l1_cur.next;
        }

        while (l2_cur != null) // 判断L2位数
        {
            count2++;
            l2_cur = l2_cur.next;
        }

        if (count1 > count2) {
            l2_cur = l2;
            int dif = count1 - count2;
            while (l2_cur.next != null) // travel to the last
            {
                l2_cur = l2_cur.next;
            }

            while (dif != 0) {
                ListNode lNew = new ListNode(0);
                lNew.next = null;

                l2_cur.next = lNew;
                l2_cur = l2_cur.next;
                dif--;
            }
        } else if (count1 < count2) {
            l1_cur = l1;
            int dif = count2 - count1;
            while (l1_cur.next != null) // travel to the last
            {
                l1_cur = l1_cur.next;
            }

            while (dif != 0) {
                ListNode lNew = new ListNode(0);
                lNew.next = null;

                l1_cur.next = lNew;
                l1_cur = l1_cur.next;
                dif--;
            }
        } else {

        }
        // deal the equal listed
        {
            l1_cur = l1;
            l2_cur = l2;
            l3_cur = l3;
            while (l1_cur != null && l2_cur != null) {
                int c = l1_cur.val + l2_cur.val;
                ListNode lNew = new ListNode(c);
                lNew.next = null;

                l3_cur.next = lNew;
                l3_cur = l3_cur.next;

                l1_cur = l1_cur.next;
                l2_cur = l2_cur.next;
            }

            l3_cur = l3.next; // >10 deal
            while (l3_cur != null) {
                if (l3_cur.val >= 10) {
                    l3_cur.val -= 10;
                    if (l3_cur.next != null) {

                        l3_cur.next.val += 1;
                    } else {
                        ListNode lNew = new ListNode(1);
                        lNew.next = null;

                        l3_cur.next = lNew;
                        l3_cur = lNew;
                    }

                    l3_cur = l3_cur.next;
                } else {
                    l3_cur = l3_cur.next;
                }
            }
            return l3.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode.print(addTwoNumbers1(l1, l2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public static void print(ListNode l) {
            StringBuilder sb = new StringBuilder();
            while (l != null) {
                sb.append(l.val);
                l = l.next;
            }
            System.out.println(sb.toString());
        }
    }
}
