package magicsquare;

import java.util.Scanner;

public class Square {

    private int[][] square;

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size) {
        square = new int[size][size];

    }
    
    //--------------------------------------
    //create new square using given 2D array
    //--------------------------------------
    public Square(int[][] matrix) {
        square = matrix;

    }

    //--------------------------------------
    //return the square 2D array
    //--------------------------------------
    public int[][] getSquare() {
        return square;
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row) {
        int total = 0;
        //Add code here!
        for(int i = 0; i < square[row].length; i++){
            total += square[row][i];
        }
        return total;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumColumn(int col) {
        int total = 0;
        //Add code here!
        for(int i = 0; i < square.length; i++){
            total += square[i][col];
        }
        return total;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag() {
        int total = 0;
        //Add code here!
        for(int i = 0; i < square.length; i++){
            total += square[i][i];
        }
        return total;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag() {
        int total = 0;
        for(int i = square.length - 1; i >= 0; i--){
            total += square[i][i];
        }
        return total;

    }

    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean isMagic() {
        //Add code here!
        int rowTotal = 0;
        int columnTotal = 0;
        for (int i = 0; i < square.length; i++) {
            rowTotal += sumRow(i);
        }
        for (int i = 0; i < square.length; i++) {
            columnTotal += sumColumn(i);
        }
        
        columnTotal = columnTotal / square.length;
        rowTotal = rowTotal / square.length;
        
        if(columnTotal == rowTotal && columnTotal == sumOtherDiag() && columnTotal == sumMainDiag()){
            return true;
        }
        else{
            return false;
        }
    }

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.println("Enter an integer number");
                square[row][col] = scan.nextInt();
            }
        }
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + "  ");
            }
            System.out.println("");
        }
    }
    
    public void randomSquare(){
        int[][] newSquare = new int[square.length][square.length];
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square[i].length; j++){
                square[i][j] = (int)(Math.random() * 100);
            }
        }
    }
    
    public boolean isUnique(){
        int prevNum = square[0][0];
        for(int i = 1; i < square.length; i++){
            for(int j = 1; j < square[i].length; j++){
                if(prevNum == square[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}