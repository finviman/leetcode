package com.home;

/**
 * Created by liyang on 4/11/20.
 * liyang27@le.com;
 * only in letv.
 */
public class AddTwoNumbers {

    public static ListNode basicAdd(ListNode l1, ListNode l2) {
        ListNode cursor = null;
        ListNode head = null;

        int nextBit = 0;
        while (l1 != null && l2 != null) {
            ListNode res = new ListNode();
            if (cursor!=null) {
                cursor.next = res;
            }else {
                head = res;
            }
            res.val = l1.val+l2.val+nextBit;
            nextBit = res.val/10;
            res.val = res.val % 10;
            l1 = l1.next;
            l2 = l2.next;
            cursor = res;
        }
        if (l1 == null && l2 == null) {
            if (nextBit == 1) {
                ListNode last = new ListNode();
                last.val=1;
                cursor.next = last;
            }
            return head;
        }
        cursor.next = l1 == null ? l2 : l1;
        cursor = cursor.next;
        while (cursor != null) {
            cursor.val = cursor.val+nextBit;
            nextBit = cursor.val/10;
            cursor.val = cursor.val % 10;
            if (cursor.next == null) {
                break;
            }else {
                cursor = cursor.next;
            }
        }
        if (nextBit == 1) {
            ListNode last = new ListNode();
            last.val=1;
            cursor.next = last;
        }
        return head;
    }
}

class ListNode{
    public int val;
    public ListNode next;
}
