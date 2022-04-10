package SudokuSolver;

public class Puzzle {

    private Box[] boxes;
    private boolean isComplete;

    /**
     * Checks if Box array is valid:
     * - exactly 9 Box objects
     * - exactly 9 unique rows (1-9) with exactly 9 Cells
     * - exactly 9 unique cols (1-9) with exactly 9 Cells
     * @param arr desired Box array
     * @return true if Box array is valid, false otherwise
     */
    public static boolean isValidBoxArray(Box[] arr){
        // TODO: implement
        return false;
    }

    public Puzzle(Box[] boxes){
        // TODO: implement
    }

    public Box[] getBoxes(){
        // TODO: implement
        return null;
    }

    public Box getBox(int num){
        // TODO: implement
        return null;
    }

    public Cell getCell(int r, int c){
        // TODO: implement
        return null;
    }

    public void setCell(int r, int c, int v){
        // TODO: implement
    }

}
