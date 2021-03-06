package SudokuSolver;

public class Cell {

    private int val, row, col;

    /**
     * checks if desired value is between 1 and 9 (both inclusive)
     * @param i desired value to check
     * @return true if the desired value is valid, false otherwise
     */
    public static boolean isValidVal(int i){
        return i >= 0 && i < 10;
    }

    /**
     * checks if desired row is between 1 and 9 (both inclusive)
     * @param i desired to row check
     * @return true if the desired row is valid, false otherwise
     */
    public static boolean isValidRow(int i){
        return i > 0 && i < 10;
    }

    /**
     * checks if desired column is between 1 and 9 (both inclusive)
     * @param i desired column to check
     * @return true if the desired column is valid, false otherwise
     */
    public static boolean isValidCol(int i){
        return i > 0 && i < 10;
    }

    /**
     * constructor for SudokuSolver.Cell object
     * @param v cell value
     * @param r cell row
     * @param c cell column
     * @throws IllegalArgumentException if at least 1 of these is invalid: v, r, c
     */
    public Cell(int v, int r, int c){
        this.setVal(v);
        this.setRow(r);
        this.setCol(c);
    }

    /**
     * accessor for the cell value
     * @return the cell value
     */
    public int getVal() {
        return this.val;
    }

    /**
     * accessor for the cell value
     * @return the cell value
     */
    public int getRow() {
        return this.row;
    }

    /**
     * accessor for the cell value
     * @return the cell value
     */
    public int getCol() {
        return this.col;
    }

    /**
     * mutator for the cell value
     * @param i desired value
     * @throws IllegalArgumentException if desired value is invalid
     */
    public void setVal(int i) {
        if(!isValidVal(i)) throw new IllegalArgumentException("value not valid");
        this.val = i;
    }

    /**
     * mutator for the cell row
     * @param i desired row
     * @throws IllegalArgumentException if desired row is invalid
     */
    public void setRow(int i) {
        if(!isValidRow(i)) throw new IllegalArgumentException("row not valid");
        this.row = i;
    }

    /**
     * mutator for the cell column
     * @param i desired column
     * @throws IllegalArgumentException if desired column is invalid
     */
    public void setCol(int i) {
        if(!isValidCol(i)) throw new IllegalArgumentException("column not valid");
        this.col = i;
    }
}
