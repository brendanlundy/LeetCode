package algorithms;

public class Problem025 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(14);
        l1.next.next.next.next = new ListNode(15);
        //l1.next.next.next.next.next = new ListNode(16);
        ListNode answer = reverseKGroup(l1, 2);
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;

        ListNode answer = null;
        ListNode endOfAnswer = null;
        ListNode currentHead = head;
        ListNode nextHead = head;
        while (nextHead != null) {
            int numThisBatch = 0;
            while (nextHead != null && numThisBatch < k - 1) {
                numThisBatch++;
                nextHead = nextHead.next;
            }

            if (nextHead != null && numThisBatch == k - 1) {
                ListNode temp = nextHead.next;
                nextHead.next = null;
                nextHead = temp;
                ListNode reversed = reverseList(currentHead);
                currentHead = nextHead;

                if (endOfAnswer != null) {
                    endOfAnswer.next = reversed;
                    while (endOfAnswer.next != null)
                        endOfAnswer = endOfAnswer.next;
                } else {
                    answer = reversed;
                    ListNode end = answer;
                    while (end.next != null)
                        end = end.next;
                    endOfAnswer = end;
                }
            } else {
                //append the remaining nodes to the end
                if (answer == null)
                    return head;
                else
                    endOfAnswer.next = currentHead;
            }
        }

        return answer;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode next = head.next;
        head.next = null;
        ListNode prev = head;
        while (next.next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        next.next = prev;
        return next;
    }
}
