package com.company.link;

import com.company.sort.ListNode;

public class ListNodeFactory {


    public static ListNode create() {
        ListNode head = new ListNode(9);

        ListNode a1 = new ListNode(7);
        head.after(a1);

        ListNode a2 = new ListNode(8);
        a1.after(a2);

        return head;
    }
}
