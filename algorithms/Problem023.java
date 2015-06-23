package algorithms;

public class Problem023 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l0 = new ListNode(12);
        l0.next = new ListNode(19);
        lists[0] = l0;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(14);
        lists[1] = l1;
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(8);
        lists[2] = l2;

        ListNode answer = mergeKLists(lists);
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

    public static ListNode mergeKLists(ListNode[] lists) {
        int numLists = lists.length;
        if (numLists == 0)
            return null;

        int bestIndex = bestList(lists, numLists);
        if (bestIndex == -1)
            return null;

        ListNode answer = lists[bestIndex];
        ListNode current = answer;
        lists[bestIndex] = lists[bestIndex].next;

        bestIndex = bestList(lists, numLists);
        while (bestIndex >= 0) {
            current.next = lists[bestIndex];
            current = current.next;
            lists[bestIndex] = lists[bestIndex].next;

            bestIndex = bestList(lists, numLists);
        }

        return answer;
    }

    private static int bestList(ListNode[] lists, int numLists) {
        int bestIndex = -1;
        int bestVal = Integer.MAX_VALUE;
        for (int i = 0; i < numLists; i++) {
            ListNode head = lists[i];
            if (head != null) {
                if (head.val <= bestVal) {
                    bestVal = head.val;
                    bestIndex = i;
                }
            }
        }

        return bestIndex;
    }
}
