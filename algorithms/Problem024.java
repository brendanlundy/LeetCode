package algorithms;

public class Problem024 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(14);
        l1.next.next.next.next = new ListNode(15);
        l1.next.next.next.next.next = new ListNode(16);
        ListNode answer = swapPairs(l1);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode current = head;
        head = head.next;
        current.next = head.next;
        head.next = current;

        while (current.next != null) {
            ListNode temp = current.next;
            if (temp.next == null)
                break;
            current.next = temp.next;
            temp.next = temp.next.next;
            current.next.next = temp;
            current = current.next.next;
        }
        return head;
    }
}
