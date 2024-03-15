// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

import java.util.*;

class ValidSudoku {
    private char EMPTY_CELL = '.';

    // This is used to determine which indicies to use depending on which sub box we are in
    private int[][] subBoxPartitionIndicies = {{0, 1, 2},{3, 4, 5},{6, 7, 8}};
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // check row is valid
            if (!isSetValid(board[i])) {
                return false;
            }

            char[] column = new char[9];
            char[] subBox = new char[9];

            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];

                // We use i % 3 to get the "x" coordinate of our subBox
                // and j % 3 to get the sub coordinate in that box
                // then reference the partition indicies table to get the real
                // "x" coordinate in the board
                int x = subBoxPartitionIndicies[i%3][j%3];

                // We use i / 3 to get the "y" coordinate of our subBox
                // and j / 3 to get the sub coordinate in that box
                // then reference teh partition indicies table to get the real
                // "y" coordinate in the board
                int y = subBoxPartitionIndicies[i/3][j/3];

                subBox[j] = board[y][x];
            }

            if (!isSetValid(column) || !isSetValid(subBox)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSetValid(char[] set) {
        HashSet<Character> dupCheck = new HashSet<>();

        for (char cell : set) {
            if (cell == EMPTY_CELL) {
                continue;
            }

            if (dupCheck.contains(cell)) {
                return false;
            }

            dupCheck.add(cell);
        }

        return true;
    }

    // First solution
    // public boolean isValidSudoku(char[][] board) {
    //     return isRowsValid(board) && isColumnsValid(board) && isSubBoxesValid(board);
    // }

    // private boolean isRowsValid(char[][] board) {
    //     for(char[] row : board) {
    //         if (!isSetValid(row)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean isColumnsValid(char[][] board) {
    //     for (int i = 0; i < 9; i++) {
    //         char[] column = new char[9];
    //         for (int j = 0; j < board.length; j++) {
    //             column[j] = board[j][i];
    //         }
    //         if (!isSetValid(column)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean isSubBoxesValid(char[][] board) {
    //     // This is used to determine which indicies to use depending on which sub box we are in
    //     int[][] subBoxPartitionIndicies = {{0, 1, 2},{3, 4, 5},{6, 7, 8}};

    //     for (int i = 0; i < 9; i++) {
    //         char[] subBox = new char[9];
    //         for (int j = 0; j < 9; j++) {
    //             // We use i % 3 to get the "x" coordinate of our subBox
    //             // and j % 3 to get the sub coordinate in that box
    //             // then reference the partition indicies table to get the real
    //             // "x" coordinate in the board
    //             int x = subBoxPartitionIndicies[i%3][j%3];

    //             // We use i / 3 to get the "y" coordinate of our subBox
    //             // and j / 3 to get the sub coordinate in that box
    //             // then reference teh partition indicies table to get the real
    //             // "y" coordinate in the board
    //             int y = subBoxPartitionIndicies[i/3][j/3];

    //             subBox[j] = board[y][x];
    //         }
    //         if (!isSetValid(subBox)) {
    //             return false;
    //         }
    //     }
    //     return true;

    // }

    // private boolean isSetValid(char[] set) {
    //     HashSet<Character> dupCheck = new HashSet<>();

    //     for (char cell : set) {
    //         if (cell == EMPTY_CELL) {
    //             continue;
    //         }

    //         if (dupCheck.contains(cell)) {
    //             return false;
    //         }

    //         dupCheck.add(cell);
    //     }

    //     return true;
    // }
}
// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

