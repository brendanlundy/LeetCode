package algorithms;

public class Problem021 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(14);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(8);
        ListNode answer = mergeTwoLists(l1, l2);
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode answer;
        ListNode current;
        if (l1.val < l2.val) {
            answer = l1;
            l1 = l1.next;
        } else {
            answer = l2;
            l2 = l2.next;
        }
        current = answer;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        return answer;
    }
}
