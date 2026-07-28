class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int maxValIndex = maxValue(mat,m,n,mid);
            int left = -1;
            if((mid-1) >= 0){
                left = mat[maxValIndex][mid-1];
            }
            int right = -1;
            if((mid + 1) < n){
                right = mat[maxValIndex][mid+1];
            }
            if(mat[maxValIndex][mid] > left && mat[maxValIndex][mid] > right){
                return new int[] {maxValIndex, mid};
            }else if(mat[maxValIndex][mid] < left){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
    public int maxValue(int[][] mat, int m, int n, int mid){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0; i<m; i++){
            if(mat[i][mid] > max){
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
}
