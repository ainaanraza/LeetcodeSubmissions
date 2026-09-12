import java.util.*;

class Solution {
    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }

        boolean isBetterThan(Result other) {
            if (other == null) return true;
            if (this.weight != other.weight) {
                return this.weight > other.weight;
            }
            int len1 = this.indices.size();
            int len2 = other.indices.size();
            int minLen = Math.min(len1, len2);
            for (int i = 0; i < minLen; i++) {
                int cmp = Integer.compare(this.indices.get(i), other.indices.get(i));
                if (cmp != 0) {
                    return cmp < 0;
                }
            }
            return len1 < len2;
        }
    }

    static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> it = intervals.get(i);
            arr[i] = new Interval(it.get(0), it.get(1), it.get(2), i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });
        Result[][] dp = new Result[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new Result(0, new ArrayList<>());
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = findNext(arr, i);

            for (int k = 1; k <= 4; k++) {
                Result best = dp[i + 1][k];
                Result nextRes = dp[nextIdx][k - 1];
                long newWeight = nextRes.weight + arr[i].weight;
                List<Integer> newIndices = insertSorted(nextRes.indices, arr[i].id);
                Result take = new Result(newWeight, newIndices);

                if (take.isBetterThan(best)) {
                    best = take;
                }

                dp[i][k] = best;
            }
        }
        List<Integer> bestIndices = dp[0][4].indices;
        int[] ans = new int[bestIndices.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = bestIndices.get(i);
        }
        return ans;
    }
    private int findNext(Interval[] arr, int curr) {
        int low = curr + 1, high = arr.length - 1;
        int target = arr[curr].r;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].l > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private List<Integer> insertSorted(List<Integer> list, int val) {
        List<Integer> res = new ArrayList<>(list.size() + 1);
        boolean inserted = false;
        for (int x : list) {
            if (!inserted && val < x) {
                res.add(val);
                inserted = true;
            }
            res.add(x);
        }
        if (!inserted) {
            res.add(val);
        }
        return res;
    }
}