package com.company.sort;

public class ListNode {
    public ListNode next;
    public ListNode prev;
    public int      val;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode after(ListNode node) {
        ListNode nextNode = next;
        this.next = node;
        node.prev = this;
        if (nextNode != null) {
            node.next = nextNode;
            nextNode.prev = node;
        }
        return this;
    }

    public int getVal() {
        return val;
    }


    public void sequenceShow() {
        ListNode next = this;
        while (next != null) {
            System.out.print(next.getVal() + " ");
            next = next.next;
        }
    }

    void reverseShow() {
        ListNode curr = this;
        while (curr != null) {
            System.out.print(curr.getVal() + " ");
            curr = curr.prev;
        }
    }
}