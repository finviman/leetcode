package com.home;

import org.junit.jupiter.api.Test;

/**
 * Created by liyang on 4/11/20.
 * liyang27@le.com;
 * only in letv.
 */
public class AddTwoNumbersTest{

    @Test
    public void test() {
        ListNode l1 = new ListNode();
        l1.val = 5;
        //ListNode l2 = new ListNode();
        //l2.val = 1;
        //ListNode l3 = new ListNode();
        //l3.val = 1;
        //l1.next = l2;
        //l2.next = l3;

        ListNode l4 = new ListNode();
        l4.val = 5;
        //ListNode l5 = new ListNode();
        //l5.val = 8;
        //ListNode l6 = new ListNode();
        //l6.val = 8;
        //ListNode l7 = new ListNode();
        //l7.val = 9;
        //ListNode l8 = new ListNode();
        //l8.val = 9;
        //l4.next = l5;
        //l5.next = l6;
        //l6.next = l7;
        //l7.next = l8;
        ListNode r = AddTwoNumbers.basicAdd(l1, l4);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

}
