class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int i = 0;
        int[][] result = new int[n + 1][2];
        int idx = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result[idx++] = intervals[i];
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result[idx++] = newInterval;

        while (i < n) {
            result[idx++] = intervals[i];
            i++;
        }

        int[][] answer = new int[idx][2];

        for (int j = 0; j < idx; j++) {
            answer[j] = result[j];
        }

        return answer;
    }
}