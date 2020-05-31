package com.tintin.linkedList;

public class LinkedListCycle{
    public static void main(String[] args) {

    }
}

class Solution141 {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast==null || fast.next==null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
