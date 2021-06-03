package com.company.sort;

/**
 * leetcode 147 对链表的插入排序
 */
public class LinkedInsertSort {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(2);
        head.after(node2);
        ListNode node3 = new ListNode(5);
        node2.after(node3);
        ListNode node4 = new ListNode(3);
        node3.after(node4);

        System.out.println("排序前");
        head.sequenceShow();
        System.out.println();
        System.out.println("排序后");
        ListNode node = insertSortList(head);
        node.sequenceShow();
    }

    private static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //h->4->2->5->3->null
        //创建哨兵
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h; //pre的next是head, cur也是head, 他俩持有同一个引用地址, 如果cur改变,pre的next也会改变
        ListNode cur = head;
        ListNode lat = null;

        while (cur != null) {
            lat = cur.next;
            if (lat != null && lat.val < cur.val) { //后面的元素比前面小, 需要换位置; lat和cur交换位置
                while (pre.next != null && pre.next.val < lat.val) {//寻找应该插入的位置
                    pre = pre.next;//默认往第一个节点插入, 如果第一个节点比要插入的小就往后走一步, 插入第二个节点上
                }
                cur.next = lat.next;//把要插入节点的下一个节点记住, 准备下一轮循环使用
                lat.next = pre.next; //赋值一下lat新的next
                //pre 节点后面的位置就是lat要插入的位置
                pre.next = lat;//lat 放入正确的位置
                pre = h;//重置,这样在while时, 才能找到正确插入节点
            } else {
                cur = lat;
            }
        }
        return h.next;
    }
}
