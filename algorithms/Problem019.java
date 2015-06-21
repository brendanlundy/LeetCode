package algorithms;

public class Problem019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        ListNode answer = removeNthFromEnd(head, 3);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //n is assumed to be valid
        //if there is only 1 node then remove that node
        if (head.next == null)
            return null;

        ListNode prev = head;
        ListNode fast = head;
        //separate the nodes by n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //if we have already gone past the end, then remove the head
        if (fast == null)
            return head.next;

        //continue until the end of the list
        while (fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }

        //remove the nth node
        prev.next = prev.next.next;
        return head;
    }
}
