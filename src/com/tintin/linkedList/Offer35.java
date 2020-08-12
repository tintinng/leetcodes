package com.tintin.linkedList;

import java.util.HashMap;

public class Offer35 {
    public static void main(String[] args) {

    }
}

/**
 *  遍历两遍,第一遍copy除random以外的其他数据，并构造一个hash表，将两个链表的节点一一对应
 *      时间：O(n)
 *      空间：O(n)
 */
class SolutionOffer35 {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node p = head;
        Node pre = dummy;
        dummy.next = p;
        // 第一遍 copy除 random以外的其他数据，并构造一个 hash表，将两个链表的节点一一对应
        while (p != null) {
            Node node = new Node(p.val);
            pre.next = node;
            pre = node;
            map.put(p, node);
            p = p.next;
        }
        // dummy已经是第二个链表的哑节点
        p = dummy.next;
        // 第二遍copy对应的 random
        while (p!=null) {
            Node rand = map.get(head.random);
            p.random = rand;
            p = p.next;
            head = head.next;
        }

        return dummy.next;
    }
}
