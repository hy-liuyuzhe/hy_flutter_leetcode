package com.company.link;

import com.company.sort.ReverseListNode;

/**
 * leetcode 21. 合并2个有序链表
 * l1: 1, 5, 8
 * l2: 2, 6, 9
 * 125689
 *
 * 递归到8和9比, 8小于9 , 9放到8后面, 回退递归; 8和6比, 8大于6, 6后面放8
 *
 * @author liuyuzhe
 */
public class Solution {

    public static void main(String[] args) {
        ReverseListNode link1 = buildLink1();
        ReverseListNode link2 = buildLink2();
        ReverseListNode listNode = mergeTwoList1(link1, link2);
        listNode.sequenceShow();
    }

    /**
     * 递归: 判断l1 和 l2 哪一个元素更小, 然后递归找到尾节点, 再反向返回结果到递归点, 按顺序赋值对应的next节点
     */
    private static ReverseListNode mergeTwoList1(ReverseListNode l1, ReverseListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoList1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 遍历: 使用一个哨兵preHead链表, 我们不断的调整他的next指针, 不断的比较2个链表的值, 把小的放入preHead链表中,
     * 直到2个链表指向null了;
     * 循环终止时, 2个链表最多有一个非空的, 放入合并的链表尾部
     */
    private static ReverseListNode mergeTwoList2(ReverseListNode l1, ReverseListNode l2) {
        ReverseListNode preHead = new ReverseListNode(-1);
        ReverseListNode prev = preHead;//维护一个临时指针
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;//前进指针
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;//从-1指向下一个真正头节点
    }


    private static ReverseListNode buildLink1() {
        ReverseListNode head = new ReverseListNode(1);
        ReverseListNode node2 = new ReverseListNode(5);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(8);
        node2.after(node3);
        return head;
    }

    private static ReverseListNode buildLink2() {
        ReverseListNode head = new ReverseListNode(2);
        ReverseListNode node2 = new ReverseListNode(6);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(9);
        node2.after(node3);
        return head;
    }


}
