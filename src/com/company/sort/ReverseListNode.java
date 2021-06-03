package com.company.sort;

public class ReverseListNode {
    public ReverseListNode next;
    public ReverseListNode prev;
    public int val;

    public ReverseListNode(int val) {
        this.val = val;
    }

    public ReverseListNode after(ReverseListNode node) {
        ReverseListNode nextNode = next;
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
        ReverseListNode next = this;
        while (next != null) {
            System.out.print(next.getVal() + " ");
            next = next.next;
        }
    }

    void reverseShow() {
        ReverseListNode curr = this;
        while (curr != null) {
            System.out.print(curr.getVal() + " ");
            curr = curr.prev;
        }
    }
}