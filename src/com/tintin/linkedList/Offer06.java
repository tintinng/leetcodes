package com.tintin.linkedList;

import java.util.Arrays;

public class Offer06 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        ListNode head = LinkedUtils.series(nums);
        SolutionOffer06 solutionOffer06 = new SolutionOffer06();
        System.out.println(Arrays.toString(solutionOffer06.reversePrint1(head)));
    }
}

/**
 *  1、将链表逆置，然后从头到尾遍历
 *    时间：O(N)
 *    空间: O(N)
 *  2、使用栈
 *  3、遍历一遍获取链表长度，然后倒着填入值
 */

class SolutionOffer06 {
    public int[] reversePrint1(ListNode head) {
        int count = 0;
        if (head == null) {
            return new int[]{};
        }
        // 链表逆置
        ListNode newHead = null;
        while (head != null) {
            ListNode l = new ListNode(head.val);
            l.next = newHead;
            count++;
            newHead = l;
            head = head.next;
        }
        // 遍历链表存到数组
        int[] nums = new int[count];
        int i = 0;
        while (newHead != null) {
            nums[i++] = newHead.val;
            newHead = newHead.next;
        }

        return nums;
    }
}