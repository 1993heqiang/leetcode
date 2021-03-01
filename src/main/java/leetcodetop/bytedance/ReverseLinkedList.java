package leetcodetop.bytedance;

import leetcodetop.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return recursivelyReverseList(head, null);
    }

    public ListNode recursivelyReverseList(ListNode head, ListNode next) {
        if (head != null) {
            ListNode temp = head.next;
            head.next = next;
            ListNode result = recursivelyReverseList(temp, head);
            return result == null ? head : result;
        } else {
            return null;
        }

    }
}
