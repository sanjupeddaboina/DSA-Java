class Solution {
  
    public int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;  // Default value if no such index is found

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int cnt_max = 0;  // Keeps track of the maximum number of 1s found so far
        int index = -1;   // Stores index of the row with maximum 1s

        for (int i = 0; i < n; i++) {
            // Count of 1s = total columns - index of first 1 (lower bound)
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}
