class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int i = 0;
        int j = 0;
        int idx = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] arr = new int[len1 + len2][2];

        while (i < len1 && j < len2) {

            if (nums1[i][0] == nums2[j][0]) {

                arr[idx][0] = nums1[i][0];
                arr[idx][1] = nums1[i][1] + nums2[j][1];

                i++;
                j++;
            }

            else if (nums1[i][0] < nums2[j][0]) {

                arr[idx][0] = nums1[i][0];
                arr[idx][1] = nums1[i][1];

                i++;
            }

            else {

                arr[idx][0] = nums2[j][0];
                arr[idx][1] = nums2[j][1];

                j++;
            }

            idx++;
        }

        while (i < len1) {

            arr[idx][0] = nums1[i][0];
            arr[idx][1] = nums1[i][1];

            i++;
            idx++;
        }

        while (j < len2) {

            arr[idx][0] = nums2[j][0];
            arr[idx][1] = nums2[j][1];

            j++;
            idx++;
        }

        return Arrays.copyOf(arr, idx);
    }
}