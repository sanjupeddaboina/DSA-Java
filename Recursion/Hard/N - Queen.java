class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n+1][n+1];
        PlaceQueens(1, n, board);
        return list;
    }
    public void PlaceQueens(int row, int n, int[][] board){
        if(row == n+1){
            List<String> combo = new ArrayList<>();
            for(int i=1; i<=n; i++){
                String str = "";
                for(int j=1; j<=n; j++){
                    if(board[i][j] == 1){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                combo.add(str);
            }
            list.add(combo);
            return;
        }
        for(int col=1; col<=n; col++){
            if(isValid(row, col, board) == true){
                board[row][col] = 1;
                PlaceQueens(row+1, n, board);
                board[row][col] = 0;
            }
        }
    }
    public boolean isValid(int row, int col, int[][] board){
        for(int i=row; i>=1; i--){
            if(board[i][col] == 1){
                return false;
            }
        }
        for(int i=row, j=col; i>=1 && j>=1; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        for(int i=row, j=col; i>=1 && j<=board[0].length-1; i--, j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
