package com.tintin.linkedList;

public class ReverseNodesinkGroup {
    public static void main(String[] args) {
        ListNode head = LinkedUtils.series(new int[]{1,2,3,4,5});
        LinkedUtils.printLink(head);
        Solution25 solution25 = new Solution25();
        LinkedUtils.printLink(solution25.reverseKGroup(head,5));
    }
}

class Solution25 {
    /**
     * 模仿两两交换的递归写法
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1 || head==null || head.next==null) {
            return head;
        }
        // p找到下一段反转的头节点
        ListNode p = head;
        for (int i=1; i<=k; i++) {
            // 不够反转长度k，递归出口
            if (p == null) {
                return head;
            }
            p = p.next;
        }

        // 反转k个节点,循环中将q1->q2变为q2->q1
        ListNode q1 = head;
        ListNode q2 = q1.next;
        ListNode q3 = q2.next;
        while (q2 != p) {
            q2.next = q1;
            q1 = q2;
            q2 = q3;
            if (q3 == null) {
                break;
            }
            q3 = q3.next;
        }

        // 和下一段接上
        head.next = reverseKGroup(p,k);

        return q1;
    }
}