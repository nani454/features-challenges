package com.nani454.challenges.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _P36_Valid_Sudoku {

    public static void main(String[] args) {
        char[][] board =
                        {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};

        System.out.println(new _P36_Valid_Sudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        for(int row=0; row<board.length; row++){
            if(!isValidRow(board, row))
                return false;
        }
        for(int col=0; col<board.length; col++){
            if(!isValidCol(board, col))
                return false;
        }
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board.length; col++){
                if(row%3 == 0 && col%3 == 0){
                    if(!isValidBox(board, row, col))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int col) {
        Set<Character> digitsSet = new HashSet<>();
        for(int i=row; i<=row+2; i++){
            for(int j=col; j<=col+2; j++){
                if(board[i][j] != '.'){
                    boolean isAdded = digitsSet.add(board[i][j]);//if the char is already present, add will return false
                    if(!isAdded){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        Set<Character> digitsSet = new HashSet<>();
        for(int i=0; i<board.length; i++){
            if(board[i][col] != '.'){
                boolean isAdded = digitsSet.add(board[i][col]);//if the char is already present, add will return false
                if(!isAdded){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> digitsSet = new HashSet<>();
        for(int i=0; i<board.length; i++){
            if(board[row][i] != '.'){
                boolean isAdded = digitsSet.add(board[row][i]);//if the char is already present, add will return false
                if(!isAdded){
                    return false;
                }
            }
        }
        return true;
    }
}
