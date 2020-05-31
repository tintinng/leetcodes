package com.tintin.linkedList;

public class LinkedUtils{
    /**
     * 根据数组创建链表
     * @param nums
     * @return
     */
    public static ListNode series(int[] nums) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        for (int i=0; i<nums.length; i++) {
            ListNode l = new ListNode(nums[i]);
            l.next = null;
            pre.next = l;
            pre = l;
        }

        return head.next;
    }

    /**
     * 顺序打印链表
     * @param l
     */
    public static void printLink(ListNode l) {
        if (l == null) {
            return;
        }
        while (l.next != null) {
            System.out.print(l.val);
            System.out.print("->");
            l = l.next;
        }
        System.out.println(l.val);
    }
}
