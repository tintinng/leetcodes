package com.tintin.linkedList;

public class Offer18 {
    public static void main(String[] args) {

    }
}

/**
 *  1、双指针，找到要删除节点的前一个节点
 *      时间：O(N)
 *      空间：O(1)
 *  2、给出要删除节点的指针（引用），可以通过覆盖值的方式实现 O(1)的时间复杂度
 */
class SolutionOffer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null || head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode p = pre.next;
        while (p!=null && p.val!=val) {
            pre = p;
            p = p.next;
        }
        // 链表中存在这个节点，则删除
        if (p!=null){
            pre.next = p.next;
        }

        return head;
    }
}