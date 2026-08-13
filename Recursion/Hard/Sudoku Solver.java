class Solution {
    public void solveSudoku(char[][] board) {
        SudokuSolver(0,0,board);
    }
    public boolean SudokuSolver(int row, int col, char[][] board){
        if(row == board.length) return true;
        int nr = row;
        int nc = col+1;
        if(nc == 9){
            nr = row + 1;
            nc = 0;
        }
        if(board[row][col] == '.'){
            for(char val = '1'; val <= '9'; val++){
                if(isValid(row, col, val, board) == true){
                    board[row][col] = val;
                    boolean res = SudokuSolver(nr, nc, board);
                    if(res == true){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }else{
            boolean res = SudokuSolver(nr, nc, board);
            return res;
        }
    }
    public boolean isValid(int row, int col, int val, char[][] board){
        for(int i=0; i<9; i++){
            if(board[row][i] == val) return false;
            if(board[i][col] == val) return false;
        }
        int stRow = (row/3)*3;
        int stCol = (col/3)*3;
        for(int i=stRow; i<stRow + 3; i++){
            for(int j=stCol; j<stCol + 3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
