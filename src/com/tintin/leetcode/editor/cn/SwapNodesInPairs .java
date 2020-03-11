//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

  
  package com.tintin.leetcode.editor.cn;
  class SwapNodesInPairs{

      static ListNode h = new ListNode(0);
      static {
          ListNode p = h;
          for(int i=1;i<6;i++){
              p.next = new ListNode(i);
              p = p.next;
          }
      }

      public static void main(String[] args) {

          ListNode q = h;
          while (q!=null){
              System.out.print(q.val+"-->");
              q = q.next;
          }
           Solution solution = new SwapNodesInPairs().new Solution();
          h = solution.swapPairs(h);
          q = h;
          while (q!=null){
              System.out.print(q.val+"-->");
              q = q.next;
          }
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
static class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        //新增一个头节点
        ListNode beforeHead = new ListNode(-1);
        beforeHead.next = head;
        ListNode beforePre = beforeHead;
        ListNode pre = head;
        ListNode post = head.next;

        //链表为空或者只有一个节点
        if(pre==null || post==null){
            return head;
        }
        while (true){
            //两两交换
            beforePre.next = post;
            pre.next = post.next;
            post.next = pre;

            //只剩一个或零个节点即可退出
            if(pre.next==null || pre.next.next==null){
                head = beforeHead.next;
                break;
            }
            beforePre = pre;
            post = pre.next.next;
            pre = pre.next;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
