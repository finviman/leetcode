package com.home;
/**
 * Definition for singly-linked list.
 */
public class RemoveLinkList{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode newHead = removeElements(l1,4);
        while(newHead!=null){
            // System.out.print(newHead.val);
            newHead = newHead.next;
        }
        test();

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode pre = new ListNode(0);
        dummy = pre;
        ListNode cursor = head;
        pre.next = cursor;
        while(cursor !=null){
            if(cursor.val == val){
                pre.next = cursor.next;
                cursor = cursor.next;
            }else{
                cursor = cursor.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    private static void test(){
        ListNode v1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        v1 = v2;
        v2 = v3;
        System.out.print(v1.val);
    }
}
