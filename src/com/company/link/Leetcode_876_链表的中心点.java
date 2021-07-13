package com.company.link;

public class Leetcode_876_链表的中心点 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(middleNode2(head));
    }

    /**
     * 先利用遍历，把链表转成一个数组
     * 第一种情况：数组个数是偶数比如6个元素，有2个中间节点为34；题目要求取后面的4，正好6/2=3,数组索引[3]后面的元素456正好满足
     * 第二种情况：数组个数是奇数比如5个元素，一个中间节点为3，5/2=2，数组索引[2]后面的元素345正好满足
     */
    public static ListNode middleNode(ListNode node) {
        ListNode[] listNodes = new ListNode[100];
        int i = 0;
        ListNode curt = node;
        while (curt != null) {
            listNodes[i++] = curt;
            curt = curt.next;
        }
        return listNodes[i / 2];
    }

    /**
     * 先利用遍历找到链表的size，然后迭代到中间节点就可以了
     */
    public static ListNode middleNode2(ListNode node) {
        int size = 0;
        ListNode sizeNode = node;
        while (sizeNode != null) {
            sizeNode = sizeNode.next;
            size++;
        }

        int k = 0;
        while (k < size / 2) {
            k++;
            node = node.next;
        }
        return node;
    }
}
