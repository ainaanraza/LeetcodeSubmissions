class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] pos = new int[100000];
        int idx = 0;
        int position = 1;

        while (head != null && head.next != null && head.next.next != null) {

            if ((head.val > head.next.val && head.next.val < head.next.next.val) ||
                (head.val < head.next.val && head.next.val > head.next.next.val)) {

                pos[idx++] = position;
            }

            head = head.next;
            position++;
        }
        if (idx < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int maxDiff = pos[idx - 1] - pos[0];

        for (int i = 1; i < idx; i++) {
            minDiff = Math.min(minDiff, pos[i] - pos[i - 1]);
        }

        return new int[]{minDiff, maxDiff};
    }
}