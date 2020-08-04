package com.tintin.linkedList;

public class Offer24 {
    public static void main(String[] args) {
        ListNode head = LinkedUtils.series(new int[]{});
        LinkedUtils.printLink(head);
        SolutionOffer24 solutionOffer24 = new SolutionOffer24();
        LinkedUtils.printLink(solutionOffer24.reverseList(head));
    }
}

/**
 *  1、头插法
 *      时间：O(N)
 *      空间：O(1)
 *  2、递归 (有点难想)
 *
 */
class SolutionOffer24{
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode p = head;
        ListNode q = head.next;
        while (true) {
            p.next = newHead;
            newHead = p;
            if (q == null){
                break;
            }
            p = q;
            q = q.next;
        }

        return newHead;
    }
}
