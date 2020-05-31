package com.tintin.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedUtils.series(new int[]{1,2});
        LinkedUtils.printLink(head);
        Solution206 solution206 = new Solution206();
        LinkedUtils.printLink(solution206.reverseList(head));
    }
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode l = new ListNode(head.val);
            l.next = newHead;
            newHead = l;
            head = head.next;
        }

        return newHead;
    }
}