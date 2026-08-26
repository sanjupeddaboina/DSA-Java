/* Largest Rectangle in Histogram: Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.
*/

class Solution {

    // Finds the largest rectangular area in the histogram
    public int largestRectangleArea(int[] heights) {

        // Stores indices of histogram bars
        Stack<Integer> st = new Stack<>();

        // Stores the maximum rectangle area
        int maxArea = 0;

        // Traverse all histogram bars
        for (int i = 0; i < heights.length; i++) {

            // Process bars taller than the current bar
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {

                // Get the index of the bar being processed
                int element = st.pop();

                // Current index is the Next Smaller Element
                int nse = i;

                // Get the Previous Smaller Element index
                int pse = st.isEmpty() ? -1 : st.peek();

                // Calculate the width of the rectangle
                int width = nse - pse - 1;

                // Calculate the rectangle area
                int area = heights[element] * width;

                // Update the maximum area
                maxArea = Math.max(maxArea, area);
            }

            // Push the current bar index into the stack
            st.push(i);
        }

        // Process all remaining bars in the stack
        while (!st.isEmpty()) {

            // Get the index of the bar being processed
            int element = st.pop();

            // No smaller element exists on the right
            int nse = heights.length;

            // Get the Previous Smaller Element index
            int pse = st.isEmpty() ? -1 : st.peek();

            // Calculate the width of the rectangle
            int width = nse - pse - 1;

            // Calculate the rectangle area
            int area = heights[element] * width;

            // Update the maximum area
            maxArea = Math.max(maxArea, area);
        }

        // Return the largest rectangle area
        return maxArea;
    }
}
