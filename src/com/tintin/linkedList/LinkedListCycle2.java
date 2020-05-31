package com.tintin.linkedList;

import java.util.HashSet;

public class LinkedListCycle2{
    public static void main(String[] args) {

    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) {
            return null;
        }
        HashSet<ListNode> nodeAddr = new HashSet<>();
        while (head.next != null) {
            if (nodeAddr.contains(head)) {
                return head;
            }
            nodeAddr.add(head);
            head = head.next;
        }
        return null;
    }
}
