package com.company.link;

import java.util.Deque;
import java.util.LinkedList;

public class Lootcode_19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(removeNthFromEnd(head, 2));
    }

    private static ListNode deleteLastNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode curt = stack.peek();
        curt.next = curt.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    private static ListNode deleteLastNode2(ListNode head, int n) {
        ListNode dumy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dumy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first!=null){
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;
        return dumy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = new ListNode(0,head);
        int length = getLength(head);
        ListNode cur = dumy;
        for(int i=0;i<length-n+1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dumy.next;
    }

    public static int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }

}
