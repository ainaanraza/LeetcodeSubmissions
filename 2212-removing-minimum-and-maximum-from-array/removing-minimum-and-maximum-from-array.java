class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int min_idx = 0;
        int max_idx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                min_idx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                max_idx = i;
            }
        }
        if (min_idx > max_idx) {
            int temp = min_idx;
            min_idx = max_idx;
            max_idx = temp;
        }
        int left = max_idx + 1;
        int right = n - min_idx;
        int both = (min_idx + 1) + (n - max_idx);
        return Math.min(left, Math.min(right, both));
    }
}