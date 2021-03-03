package leetcodetop.bytedance;

import leetcodetop.ListNode;

import java.util.Stack;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<Integer> aStack = new Stack<>();
        Stack<Integer> bStack = new Stack<>();

        ListNode curANode = headA;
        ListNode curBNode = headB;

        while (curANode != null) {
            aStack.push(curANode.val);
            curANode = curANode.next;
        }

        while (curBNode != null) {
            bStack.push(curBNode.val);
            curBNode = curBNode.next;
        }

        ListNode next = null;
        int a, b;
        while (!aStack.empty() && !bStack.empty()) {
            a = aStack.pop();
            b = bStack.pop();
            if (a == b) {
                ListNode node = new ListNode(a);
                node.next = next;
                next = node;
            } else {
                break;
            }
        }
        return next;
    }
}
