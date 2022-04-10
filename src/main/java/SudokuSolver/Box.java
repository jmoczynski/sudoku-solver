package SudokuSolver;

public class Box {

    private Cell[] cells;
    private boolean isComplete;

    /**
     * Checks desired Cell array for the following:
     * - array has exactly 9 elements
     * - exactly 3 cells have matching row
     * - exactly 3 rows represented
     * - exactly 3 cells have matching column
     * - exactly 3 columns represented
     * @param c desired Cell array
     * @return true if all checks are true, false otherwise
     */
    public static boolean isValidCellArray(Cell[] c){
        // TODO: implement method
        return false;
    }

    /**
     * Box constructor
     * @param c array of Cells that make up the box
     * @throws IllegalArgumentException if Cell array not valid
     */
    public Box(Cell[] c){
        // TODO: implement method
    }

    /**
     * accessor for Cell array
     * @return Cell array
     */
    public Cell[] getCells() {
        // TODO: implement method
        return null;
    }

    /**
     * accessor for specific Cell in Box
     * @param r row of Cell
     * @param c column of Cell
     * @return
     * @throws IllegalArgumentException if not valid row or column
     */
    public Cell getCell(int r, int c){
        // TODO: implement method
        return null;
    }

    /**
     * accessor for if Box is complete
     * @return whether Box is complete or not
     */
    boolean getComplete(){
        // TODO: implement method
        return false;
    }

    /**
     * mutator for Cell array
     * @param c desired Cell array
     * @throws IllegalArgumentException if the Cell array is not valid
     */
    public void setCells(Cell[] c) {
        // TODO: implement method
    }

    /**
     * mutates complete property of Box
     * @param complete whether Box is complete or not
     */
    private void setComplete(boolean complete){
        // TODO: implement method
    }

    /**
     * checks if Box is complete and mutates complete property
     * @return Box complete property
     */
    public boolean checkComplete(){
        // TODO: implement method
        return false;
    }
}
