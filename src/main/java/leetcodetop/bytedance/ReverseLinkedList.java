package leetcodetop.bytedance;

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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
