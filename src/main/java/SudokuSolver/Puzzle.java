package SudokuSolver;

import java.util.*;

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
        if(arr.length != 9) return false;
        Map<Integer, Integer> rowMap = new HashMap<>(), colMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null) return false;
        }
        Iterator<Cell> bcIter;
        Cell c;
        int rowVal, colVal;
        for(Box b : arr){
            bcIter = Arrays.stream(b.getCells()).iterator();
            while(bcIter.hasNext()){
                c = bcIter.next();
                rowVal = c.getRow();
                colVal = c.getCol();
                if(!rowMap.containsKey(rowVal)){rowMap.put(rowVal, 1);}
                else rowMap.replace(rowVal, rowMap.get(rowVal) + 1);
                if(!colMap.containsKey(colVal)){colMap.put(colVal, 1);}
                else colMap.replace(colVal, colMap.get(colVal) + 1);
            }
        }
        Set<Integer> rowSet = new HashSet<>(), colSet = new HashSet<>();
        rowSet.addAll(rowMap.values());
        colSet.addAll(colMap.values());

        if(rowSet.size() != 1 || colSet.size() != 1) return false;
        if(!rowSet.contains(9) || !colSet.contains(9)) return false;
        return true;
    }

    /**
     * constructor method for Puzzle
     * @param boxes desired Box array to make Puzzle
     * @throws IllegalArgumentException if Box array invalid
     */
    public Puzzle(Box[] boxes){
        // TODO: implement
        this.setBoxes(boxes);
    }

    /**
     * accessor method for Puzzle boxes
     * @return Box array of Puzzle boxes
     */
    public Box[] getBoxes(){
        // TODO: implement
        return this.boxes;
    }

    /**
     * accessor method for specific Puzzle box:
     * - box 1: rows 1,2,3 intersect cols 1,2,3
     * - box 2: rows 1,2,3 intersect cols 4,5,6
     * - box 3: rows 1,2,3 intersect cols 7,8,9
     * - box 4: rows 4,5,6 intersect cols 1,2,3
     * - box 5: rows 4,5,6 intersect cols 4,5,6
     * - box 6: rows 4,5,6 intersect cols 7,8,9
     * - box 7: rows 7,8,9 intersect cols 1,2,3
     * - box 8: rows 7,8,9 intersect cols 4,5,6
     * - box 9: rows 7,8,9 intersect cols 7,8,9
     * @param num the number of the Box to get
     * @return the Box corresponding to the number
     * @throws IllegalArgumentException if num not > 0 or < 10
     */
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

    /**
     * mutator method for the Box array of the Puzzle
     * @param boxes the desired Box array
     * @throws IllegalArgumentException if the Box array is invalid
     */
    private void setBoxes(Box[] boxes){
        // TODO: implement
        if(!isValidBoxArray(boxes)) throw new IllegalArgumentException("Box array invalid");
        this.boxes = boxes;
    }

    /**
     * accessor for Puzzle completeness property
     * @return true if Puzzle is complete, false otherwise
     */
    public boolean isComplete(){
        // TODO: implement
        return false;
    }

    /**
     * mutator for Puzzle completeness property
     * @param isComplete whether Puzzle is complete or not
     */
    private void setComplete(boolean isComplete){
        // TODO: implement
    }

    /**
     * checks if Puzzle is complete and updates Puzzle completeness property accordingly
     */
    public void checkComplete(){
        // TODO: implement
    }

}
