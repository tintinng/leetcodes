package com.tintin.backtracking;

import javax.print.DocFlavor;
import javax.sound.midi.MidiFileFormat;

public class Offer12 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a','b','c','e'},
//                {'s','f','c','s'},
//                {'a','d','e','e'}
//                {'a'},
//                {'s'},
//                {'a'}
        };
        String word = new String("");
        SolutionOffer12 solutionOffer12 = new SolutionOffer12();
        System.out.println(solutionOffer12.exist( board, word));
    }
}

/**
 *  1、回溯
 */

class SolutionOffer12 {
    private boolean[][] visited;
    private boolean found = false;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                test( i, j, 0, word, board);
            }
        }

        return found;
    }

    private void test(int x, int y, int charNum, String word, char[][] board) {
        if (found) {
            return;
        }
        if (word.charAt(charNum) != board[x][y]) {
            return;
        }
        if (charNum == word.length()-1) {
            found = true;
            return;
        }
        visited[x][y] = true;
        if (x-1>=0 && !visited[x-1][y]) {
            test(x-1, y, charNum+1, word, board);
        }
        if (y+1<board[0].length && !visited[x][y+1]) {
            test( x, y+1, charNum+1, word, board);
        }
        if (x+1<board.length && !visited[x+1][y]) {
            test( x+1, y, charNum+1, word, board);
        }
        if (y-1>=0 && !visited[x][y-1]) {
            test( x, y-1, charNum+1, word, board);
        }
        visited[x][y] = false;
    }
}