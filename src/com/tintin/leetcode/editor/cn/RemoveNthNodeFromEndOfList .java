//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


  
  package com.tintin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class RemoveNthNodeFromEndOfList{

      public static void main(String[] args) {

          ListNode head = new ListNode(0);
          ListNode p = head;
          for(int i=1;i<2;i++){
              p.next = new ListNode(i);
              p = p.next;
          }

          soutListnode(head);

          Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

          head = solution.removeNthFromEnd(head,1);

          soutListnode(head);
      }

      public static void soutListnode(ListNode head){
          ListNode p = head.next;
          while (p!=null){
              if(p.next==null){
                  System.out.println(p.val);
                  break;
              }
              System.out.print(p.val + "-->");
              p = p.next;
          }
      }
      

//leetcode submit region begin(Prohibit modification and deletion)

// Definition for singly-linked list.
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //根据list结构head应该指向第一个节点

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i=0;i<=n;i++){//p2往后移n+1个单位
            p2 = p2.next;
        }
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode del_p = p1.next;   //p1的next即为要删除的节点
        p1.next = del_p.next;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
