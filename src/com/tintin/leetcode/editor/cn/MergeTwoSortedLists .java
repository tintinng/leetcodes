//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

  
  package com.tintin.leetcode.editor.cn;
  class MergeTwoSortedLists{

      private static ListNode l1 = null;
      private static ListNode l2 = null;

      MergeTwoSortedLists(){
          for(int i=6;i>0;i--){
              ListNode p = new ListNode(i);
              p.next = l1;
              l1 = p;
          }
          for(int i=1;i>0;i--){
              ListNode p = new ListNode(i);
              p.next = l2;
              l2 = p;
          }
      }

      public static void main(String[] args) {

           Solution solution = new MergeTwoSortedLists().new Solution();

          soutListNode(l1);
          soutListNode(l2);
//          l2=null;
           ListNode head = solution.mergeTwoLists(l1,l2);
           soutListNode(head);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public static void soutListNode(ListNode head){
    ListNode p = head;
    while (p!=null){
        if(p.next==null){
            System.out.println(p.val);
            break;
        }
        System.out.print(p.val + "-->");
        p = p.next;
    }
}

    class ListNode{
        int val;
        ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l2==null){
                return l1;
            }
            if(l1==null){
                return l2;
            }
            ListNode head = null;
            if(l1.val<=l2.val){//确定头节点
                head = l1;
                l1 = l1.next;
            }else {
                head = l2;
                l2 = l2.next;
            }
            ListNode tail = head;

            while (l1!=null && l2!=null){//较小节点尾插
                if(l1.val<=l2.val){
                    tail.next = l1;
                    l1 = l1.next;
                }
                else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            if(l2==null){
                while (l1!=null){
                    tail.next = l1;
                    l1 = l1.next;
                    tail = tail.next;
                }
            }else {
                while (l2!=null){
                    tail.next = l2;
                    l2 = l2.next;
                    tail = tail.next;
                }
            }

            return head;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
