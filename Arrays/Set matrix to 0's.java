class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return;
        int cols = matrix[0].length;
        boolean zeroRow = false;
        boolean zeroCol = false;
        for(int i=0; i<cols; i++){
            if(matrix[0][i] == 0){
                zeroRow = true;
                break;
            }
        }
        for(int j=0; j<rows; j++){
            if(matrix[j][0] == 0){
                zeroCol = true;
                break;
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(zeroRow){
            for(int i=0; i<cols; i++){
                matrix[0][i] = 0;
            }
        }
        if(zeroCol){
            for(int j=0; j<rows; j++){
                matrix[j][0] = 0;
            }
        }
    }
}
