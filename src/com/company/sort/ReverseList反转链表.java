package com.company.sort;

/**
 * 翻转链表
 *
 * 递归就是通过重复调用函数自身实现循环；满足终止条件时会逐层返回来结束循环
 */
public class ReverseList反转链表 {

    public static void main(String[] args) {
        ReverseListNode head = new ReverseListNode(9);
        ReverseListNode node2 = new ReverseListNode(8);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(7);
        node2.after(node3);
        ReverseListNode node4 = new ReverseListNode(6);
        node3.after(node4);
        ReverseListNode node5 = new ReverseListNode(5);
        node4.after(node5);
        ReverseListNode node6 = new ReverseListNode(4);
        node5.after(node6);
        ReverseListNode node7 = new ReverseListNode(3);
        node6.after(node7);



        head.sequenceShow();

        ReverseListNode newRoot = reverseList1(head);
        System.out.println();
        newRoot.sequenceShow();
    }

    /**
     * 迭代方式
     *
     * 使用prev和curr 2个指针来反转每一个节点; 从头节点开始, 依次往后遍历, 分别把当前节点和下一个节点持久化, 并反向链接上;
     * 然后输入最后一个节点, 也就是第一个节点
     */
    private static ReverseListNode reverseList1(ReverseListNode head) {
        ReverseListNode prev = null; // 从头节点一直走到了尾节点
        ReverseListNode curr = head;
        while (curr != null) {
            ReverseListNode next = curr.next;
            curr.next = prev; //链表反转, 当前元素反指向
            prev = curr;//指针向下走一步
            curr = next;
        }
        return prev;
    }

    /**
     * 递归方式
     *
     * 1.找到最后一个节点并返回。因为是链表翻转所以最后一个节点，翻转后就变成第一个节点；我们递归找到最后一个节点，并作为最终参数返回
     * 2.让每一个节点反向指向它上一个节点；实现方式，递归到最后一个节点开始逐层返回递归，
     * 并且让自己的下一个节点指向自己，自己不再指向下一个节点（让指向箭头翻转180度，反向指向节点）
     *
     */
    private static ReverseListNode reverseList2(ReverseListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ReverseListNode p = reverseList2(head.next);
        head.next.next = head;//链表反转
        head.next = null;//清理 当前节点 正序链表的引用
        return p;
    }

    /**
     * 1 2 3 4 5 -> 3 2 1 4 5
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     *
     * 通过建立一个假的头节点, 持久化2个快慢指针, 分别用于持久化反转前的上一个点和返回后的下一节点
     * 让快指针移动k个位置, 找到反转节点, 反转k个节点, 然后快慢指针分别移动到k+1的位置; 重复上一轮操作,
     * 直到找不到 反转节点
     *
     * start.next = next; k节点反转后的新起始节点, 把他给快慢指针, 开启新一轮反转工作
     * dummy.next 和 pre.next 和 start 持有同一个引用, 我们对start进行反转, 也就是对结果dummy.next的反转
     *
     */
    private static ReverseListNode reverseList3(ReverseListNode head) {
        ReverseListNode dummy = new ReverseListNode(0);
        dummy.next = head;
        ReverseListNode pre = dummy;
        ReverseListNode end = dummy;
        int k = 3;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;

            ReverseListNode start = pre.next;//反转链表方法 入参是开始节点
            ReverseListNode next = end.next;
            end.next = null;//让反转有结束点

            pre.next = reverseList1(start);//从头开始反转, 直到为null
            //翻转前start是起点, reverse后为终点
            start.next = next;//翻转前在 end.next = null, 给赋值为null, 现在给它一个后继节点
            //合并链表
            pre = start;
            end = pre; //默认pre == end == start
        }
        return dummy.next;//dumy和pre同一个引用地址
    }

    /**
     * 从索引 from 2 to 4  head->5->4->3->2->1
     * <p>
     * head->5->2->3->4->1
     * <p>
     * from-1, from, to, to+1 四个结点
     */
    private static ReverseListNode reverseList4(ReverseListNode head) {
        int fromIndex = 2;
        int toIndex = 4;

        ReverseListNode dummy = new ReverseListNode(0);
        dummy.next = head;
        //0head.prev = node;

        ReverseListNode fromPre = null;//5
        ReverseListNode from = null;//4
        ReverseListNode to = null;//2
        ReverseListNode toNext = null;//1


        ReverseListNode temp = head;
        int index = 1;
        //找到4个节点
        while (temp != null) {
            if (index == fromIndex - 1) {
                fromPre = temp;
            } else if (index == fromIndex) {
                from = temp;
            } else if (index == toIndex) {
                to = temp;
            } else if (index == toIndex + 1) {
                toNext = temp;
            }
            index++;
            temp = temp.next;
        }

        //翻转 from到to
        ReverseListNode prev = from;
        ReverseListNode curr = prev.next;
        while (curr != toNext) {
            ReverseListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //把 fromPre -> to , from -> toNext

        fromPre.next = to;
        from.next = toNext;

        return dummy.next;
    }
}
