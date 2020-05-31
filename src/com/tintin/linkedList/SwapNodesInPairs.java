package com.tintin.linkedList;

public class SwapNodesInPairs{
    public static void main(String[] args) {
        ListNode head = LinkedUtils.series(new int[]{});
        LinkedUtils.printLink(head);
        Solution24 solution24 = new Solution24();
        LinkedUtils.printLink(solution24.swapPairs(head));
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 没有节点或只有一个节点时直接返回
        if (head==null || head.next==null) {
            return head;
        }
        // 三指针
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        // 交换后第二个节点为头节点
        head = second;
        while (true) {
            // 交换两个节点
            second.next = first;
            first.next = third;
            // 后续没有节点或只有一个节点时退出
            if (third==null || third.next==null) {
                break;
            }
            // 交换下两个节点时，第二个节点在前
            first.next = third.next;
            // 三个指针往后移
            first = third;
            second = third.next;
            third = second.next;
        }
        return head;
    }
}