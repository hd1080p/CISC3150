/*
 * Harris Dizdarevic
 * CISC. 3150
 * Homework 6: N-Queens
 * Write a program that finds and prints all the solutions to the N-Queens
 * problem for a given N. At the end of your program, print how many
 * solutions were found.
 *
 * N-Queens Algorithm
 *  Definition of N-Queens Problem: (adapted from wikipedia definition: https://en.wikipedia.org/wiki/Eight_queens_puzzle)
 *      N queens are placed on a NxN chess board and none of the queens are
 *      able to attack eachother meaning, any two queens cannot share the same
 *      row column or diagonal
 *
 *   Auxillary method:
 *       need to check if the queen placed in the board is not conflicted with existing queens on the board. If it is then it has to find another place
 *       where it is safe (i.e. next position in the row);
 *
 *      Auxillary method to check queenIsSafe then and whatever is returned, either it will proceed to the next queen or find a new spot
 *
 * I will be formatting my chess board as follows:
 *      1 will indicate as a queen, all other values will be 0
 *
 *  Step by step process:
 *      This problem can defined recursively as it is a variation of DFS (as
 *      indicated from the 2D combinations problem that this can be solved the
 *      same way). It is a variation of DFS in the sense that it keeps placing
 *      all possible queens until it hits a roadblock where no queens can be
 *      placed in a row and then the I would have to move the conflicting queen
 *      to an appropriate place, etc...hence the backtracking
 *
 */

import java.util.Scanner;
import java.util.Arrays;

public class nQueensSolution {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the chess board size & queens you would like to see solutions for");
        int n = userInput.nextInt();
        int[][] chessBoard = new int[n][n];
        Solver solveNQueens = new Solver();
        //Start at 0 to place the first queen at 0,0 or the most top left
        //corner
        solveNQueens.nQueensSolver(chessBoard, 0);
    }
}

class Solver {
    int solutions;

    Solver() {
        this.solutions = 0;
    }

    public void printNumSolutions() {
        System.out.println("Solutions: " + this.solutions);
    }

    public void nQueensSolver(int[][] chessBoard, int currColumn) {
        if(currColumn == chessBoard.length) {  //the length of the board is equal to the number of columns
            this.solutions += 1;
            printBoard(chessBoard);
            printNumSolutions();
            return; // need this return so it does not infinitely recurse
        }
       for(int row = 0; row < chessBoard.length; row++) {
            if(queenIsSafe(chessBoard, row, currColumn)) {
                chessBoard[row][currColumn] = 1;
                nQueensSolver(chessBoard, currColumn+1);

                chessBoard[row][currColumn] = 0; //Occupied area is not safe from attacking queens

            }
        }
    }

    //taken from: https://stackoverflow.com/questions/19648240/java-best-way-to-print-2d-array/19648326
    public void printBoard(int[][] chessBoard) {
        for(int[] row : chessBoard) { //From my understanding this is equivalant to a foreach statement, where as long as there exists an int[] object it will run
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public boolean queenIsSafe(int[][] chessBoard, int currRow, int currColumn) {
        /*Three Cases:
         *  1) Same Row
         *  2) Major Diagonal
         *  3) Minor Diagonal
         *
         *  TODO: maybe find a more efficient way to calculate this?
         *        This is a very brute force way of doing things where I
         *        iterate on three different loops to check different cases.
         *        Cant think of a more efficient way right now other than this
         *
         *        Complexit is O(3n) (?) since there are three independent loops
         *        T(n) = n + n + n
         *
         *  Best way to illustrate major versus minor diagonal is as so:
         *          \ /
         *           Q
         *
         *  where the '\' is the Major and '/' is the Minor
         *
         *  By definition Major diagonal runs from top left to bottom right
         *      source: http://chortle.ccsu.edu/vectorlessons/vmch13/vmch13_17.html
         */
        int row, column;

        //Same Row
        for(row = 0; row < currColumn; row++) {
            if(chessBoard[currRow][row] == 1) {
                return false;
            }
        }

        //iterate through the major diagonal
        for(row = currRow, column = currColumn; row >= 0 && column >= 0; row--, column--) {
            if(chessBoard[row][column] == 1) {
                return false;
            }
        }

        //Minor Diagonal
        for(row = currRow, column = currColumn; row < chessBoard.length && column >= 0; row++, column--) {
            if(chessBoard[row][column] == 1) {
                return false;
            }
        }

        return true;
    }
}
