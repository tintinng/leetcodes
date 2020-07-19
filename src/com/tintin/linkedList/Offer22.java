package com.tintin.linkedList;

public class Offer22 {
    public static void main(String[] args) {
        SolutionOffer22 solutionOffer22 = new SolutionOffer22();
        ListNode l = LinkedUtils.series(new int[]{1});
        LinkedUtils.printLink(l);
        LinkedUtils.printLink(solutionOffer22.getKthFromEnd(l,2));
    }
}

/**
 *  1、快慢双指针，快指针先跑 k 个单位。俩指针再同时跑直到快指针跑到结尾
 *      时间：O(N)
 *      空间：O(1)
 */
class SolutionOffer22{
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode last = head;
        ListNode p = head;
        while (k-- > 0) {
            last = last.next;
            if (last == null && k > 0) {
                System.out.println("Not existing!");
                return null;
            }
        }
        while (last != null) {
            p = p.next;
            last = last.next;
        }

        return p;
    }
}