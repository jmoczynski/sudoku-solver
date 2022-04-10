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
        this.setCells(c);
        this.checkComplete();
    }

    /**
     * accessor for Cell array
     * @return Cell array
     */
    public Cell[] getCells() {
        return this.cells;
    }

    /**
     * accessor for specific Cell in Box
     * @param r row of Cell
     * @param c column of Cell
     * @return desired Cell in Box
     * @throws IllegalArgumentException if row or column is invalid
     * @throws NullPointerException if no Cell in desired row or column
     */
    public Cell getCell(int r, int c){
        if(!Cell.isValidRow(r) || !Cell.isValidCol(c)) throw new IllegalArgumentException("invalid row or column");
        Iterator<Cell> cellIter = Arrays.asList(this.getCells()).iterator();
        Cell cell;
        while(cellIter.hasNext()){
            cell = cellIter.next();
            if(cell.getRow() == r && cell.getCol() == c) return cell;
        }
        throw new NullPointerException("cell not found");
    }

    /**
     * private mutator method for Cell array
     * @param c desired Cell array
     * @throws IllegalArgumentException if desired Cell array is not valid
     */
    private void setCells(Cell[] c){
        if(!isValidCellArray(c)) throw new IllegalArgumentException("Cell array not valid");
        this.cells = c;
    }

    /**
     * accessor for if Box is complete
     * @return whether Box is complete or not
     */
    boolean getComplete(){
        return this.isComplete;
    }

    /**
     * mutator for specific Cell
     * @param r Cell row
     * @param c Cell col
     * @param v Cell desired value
     * @throws IllegalArgumentException if desired value is invalid or cell row or column is invalid
     * @throws NullPointerException if the desired row or column do not exist in Box
     */
    public void setCell(int r, int c, int v){
        Cell cell = this.getCell(r, c);
        cell.setVal(v);
    }

    /**
     * mutates complete property of Box
     * @param complete whether Box is complete or not
     */
    private void setComplete(boolean complete){
        this.isComplete = complete;
    }

    /**
     * checks if Box is complete and mutates complete property:
     * - box has 9 unique values
     * @return Box complete property
     */
    public boolean checkComplete(){
        final int COMPLETE_SIZE = 9;
        Set<Integer> valSet = new HashSet<>();
        Iterator<Cell> cellIter = Arrays.stream(this.cells).iterator();
        while(cellIter.hasNext()) valSet.add(cellIter.next().getVal());
        if(valSet.size() != COMPLETE_SIZE) {
            this.setComplete(false);
        }else this.setComplete(true);
        return this.getComplete();
    }
}
