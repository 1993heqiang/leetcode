package com.rookie.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *  bad solution
 */
public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        ListNode result = sortList.sortList(head);
        System.out.println(result);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort(Comparator.comparingInt(e -> e.val));
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(size - 1).next = null;
        return list.get(0);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
