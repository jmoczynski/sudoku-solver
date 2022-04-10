package SudokuSolver;

import java.util.*;

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
        final int EXPECTED_LENGTH = 9, EXPECTED_DISTINCT = 3, EXPECTED_COUNT = 3;
        if(c.length != EXPECTED_LENGTH) return false;
        int[] rows = new int[c.length], cols = new int[c.length];
        if(rows.length != EXPECTED_LENGTH || cols.length != EXPECTED_LENGTH) return false;
        for(int i = 0; i < EXPECTED_LENGTH; i++){
            rows[i] = c[i].getRow();
            cols[i] = c[i].getCol();
        }
        Map<Integer, Integer> rowMap = new HashMap<>(), colMap = new HashMap<>();
        Iterator<Integer> rowIter = Arrays.stream(rows).iterator(), colIter = Arrays.stream(cols).iterator();
        int r1, c1;
        while(rowIter.hasNext() || colIter.hasNext()){
            r1 = rowIter.next();
            c1 = colIter.next();
            rowMap.putIfAbsent(r1, 0);
            rowMap.replace(r1, rowMap.get(r1) + 1);
            colMap.putIfAbsent(c1, 0);
            colMap.replace(c1, colMap.get(c1) + 1);
        }
        if(rowMap.size() != EXPECTED_DISTINCT || colMap.size() != EXPECTED_DISTINCT) return false;
        if(rowMap.values().size() != EXPECTED_COUNT || colMap.values().size() != EXPECTED_COUNT) return false;
        return true;
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
     * mutator for specific Cell
     * @param r Cell row
     * @param c Cell col
     * @param v Cell desired value
     * @throws IllegalArgumentException if desired value is invalid
     */
    public void setCell(int r, int c, int v){
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
     * checks if Box is complete and mutates complete property:
     * - box has 9 unique values
     * @return Box complete property
     */
    public boolean checkComplete(){
        // TODO: implement method
        return false;
    }
}
