import java.util.*;

class Solution {
    // Function to find union of two sorted arrays using two pointers
    public List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        // List to store union elements
        List<Integer> Union = new ArrayList<>();
        // Initialize pointers
        int i = 0, j = 0;
        // Iterate while both arrays have elements
        while (i < n && j < m) {
            // If element in arr1 is smaller
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;  // Move pointer in arr1
            }
            // If element in arr2 is smaller
            else if (arr2[j] < arr1[i]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;  // Move pointer in arr2
            }
            else {
                // Elements are equal, add once if not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++; j++;  // Move both pointers
            }
        }
        // Append remaining elements from arr1
        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        // Append remaining elements from arr2
        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        // Return the union list
        return Union;
    }
}
