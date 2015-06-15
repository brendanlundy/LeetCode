package algorithms;

public class Problem002 {

    public static void main(String[] args) {
        /*
        ListNode head1 = createList(new int[] { 9, 8, 8, 1 });
        ListNode head2 = createList(new int[] { 3, 3, 2 });
        ListNode sum = addTwoNumbers(head1, head2);
        System.out.print("");
        */
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode createList(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        if (numbers.length > 1) {
            ListNode current = new ListNode(numbers[1]);
            head.next = current;

            for (int i = 2; i < numbers.length; i++) {
                ListNode next = new ListNode(numbers[i]);
                current.next = next;
                current = next;
            }
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = null;
        ListNode current = null;
        boolean carry = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (carry)
                sum = 1;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                sum -= 10;
                carry = true;
            } else {
                carry = false;
            }
            ListNode next = new ListNode(sum);
            if (answer == null) {
                answer = next;
            } else {
                current.next = next;
            }
            current = next;
        }

        if (carry) {
            ListNode next = new ListNode(1);
            current.next = next;
        }

        return answer;
    }

    public static ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {

        ListNode rev1 = reverseList(l1);
        ListNode rev2 = reverseList(l2);

        ListNode answer = addTwoNumbers(rev1, rev2);
        return reverseList(answer);
    }

    private static ListNode reverseList(ListNode list) {
        ListNode current = list;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
