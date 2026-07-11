class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int lastIndex = 0;
        int[][] result = new int[n][2];
        result[lastIndex] = Arrays.copyOf(intervals[0],2);
        for(int i=1; i<n; i++){
            if(intervals[i][0] > result[lastIndex][1]){
                result[++lastIndex] = Arrays.copyOf(intervals[i],2);
            }else{
                result[lastIndex][1] = Math.max(intervals[i][1], result[lastIndex][1]);
            }
        }
        result = Arrays.copyOf(result, lastIndex + 1);
        return result;
    }
}
