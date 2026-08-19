/* Minimum Area Rectangle:
You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.
*/

class Solution {
    public int minAreaRect(int[][] points) {
        int n = points.length;
        
        Set<String> set = new HashSet<>();
        for(int[] point : points){
            set.add(point[0] + "," + point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];

            for(int j = i + 1; j < n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 || y1 == y2) continue;

                if(set.contains(x1 + "," + y2) && set.contains(x2 + "," + y1)){
                    int currArea = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    minArea = Math.min(currArea, minArea);
                }
            }
        }

        return (minArea == Integer.MAX_VALUE) ? 0 : minArea;
    }
}
