package com.tintin.linkedList;

public class Offer25 {
    public static void main(String[] args) {
        ListNode l1 = LinkedUtils.series(new int[]{1,2,3,4,5});
        ListNode l2 = LinkedUtils.series(new int[]{2,2,3,4,6,7});
        SolutionOffer25 solutionOffer25 = new SolutionOffer25();
        LinkedUtils.printLink(solutionOffer25.mergeTwoLists(l1,l2));
        LinkedUtils.printLink(solutionOffer25.mergeTwoLists1(l1,l2));
    }
}

/**
 *  1、双指针，类似于归并。
 *      时间：O(max(m,n))
 *      空间：O(m+n)新创建一个链表
 *  2、将l2插入到l1上
 *      时间：O(max(m,n))
 *      空间：O(1)
 */
class SolutionOffer25{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode dummy = pre;
        while (l1!=null && l2!=null) {
            ListNode p = new ListNode(-1);
            if (l1.val <= l2.val){
                p.val = l1.val;
                l1 = l1.next;
            }else {
                p.val = l2.val;
                l2 = l2.next;
            }
            pre.next = p;
            pre = pre.next;
        }
        // 处理剩余结点
        if (l1 == null) {
            while (l2 != null) {
                ListNode p = new ListNode(l2.val);
                pre.next = p;
                pre = pre.next;
                l2 = l2.next;
            }
        }else {
            while (l1 != null) {
                ListNode p = new ListNode(l1.val);
                pre.next = p;
                pre = pre.next;
                l1 = l1.next;
            }
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode pre = dummy;
        while (l2 != null) {
            while (l1 != null && l1.val <= l2.val){
                l1 = l1.next;
                pre = pre.next;
            }
            if (l1 == null) {
                // 直接将l2拼接到l1后面
                pre.next = l2;
                break;
            }
            // 将 l2插入到pre和l1之间
            ListNode p = l2.next;
            pre.next = l2;
            l2.next = l1;
            pre = l2;
            l2 = p;
        }

        return dummy.next;
    }
}
