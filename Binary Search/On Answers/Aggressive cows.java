import java.util.*;

class Solution {
    public boolean canPlace(int[] stalls, int cows, int d) {
        // Place first cow at first stall
        int count = 1;
        int lastPos = stalls[0];
        
        // Loop through stalls
        for (int i = 1; i < stalls.length; i++) {
            // If stall is at least d away from last placed cow
            if (stalls[i] - lastPos >= d) {
                // Place cow here
                count ++;
                // Update last position
                lastPos = stalls[i];
            }
            // If all cows are placed successfully
            if (count >= cows) return true;
        }
        // Could not place all cows
        return false;
    }

    // Function to maximize minimum distance
    public int aggressiveCows(int[] stalls, int cows) {
        // Sort stalls
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
