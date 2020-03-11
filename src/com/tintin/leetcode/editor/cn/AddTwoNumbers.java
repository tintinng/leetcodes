//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

  
  package com.tintin.leetcode.editor.cn;
  public class AddTwoNumbers{
      public static void main(String[] args) {
          Solution solution = new AddTwoNumbers().new Solution();
          ListNode l1 = new AddTwoNumbers().new ListNode(2);
          ListNode l2 = new AddTwoNumbers().new ListNode(4);
          ListNode l3 = new AddTwoNumbers().new ListNode(3);
          l1.next = l2;
          l2.next = l3;
          l3.next = null;

          ListNode l4 = new AddTwoNumbers().new ListNode(5);
          ListNode l5 = new AddTwoNumbers().new ListNode(6);
          ListNode l6 = new AddTwoNumbers().new ListNode(4);
          l4.next = l5;
          l5.next = l6;
          l6.next = null;

          ListNode l = solution.addTwoNumbers(l1,l4);
          while(l!=null)
          {
              System.out.println(l.val);
              l = l.next;
          }
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lRes = new ListNode(0);
        ListNode p1 = l1,p2 = l2;
        ListNode l = lRes;
        int carry = 0;
        while(true)
        {
            if(p1==null){
                p1 = new ListNode(0);
            }
            if(p2==null){
                p2 = new ListNode(0);
            }

            lRes.val = (p1.val + p2.val + carry)%10;
            carry = (p1.val + p2.val + carry)/10;

            p1 = p1.next;
            p2 = p2.next;
            if(p1==null && p2==null && carry==0){
                break;
            }
            else{
                lRes.next = new ListNode(0);
                lRes = lRes.next;
            }
        }

        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
