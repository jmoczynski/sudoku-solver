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
        this.setBoxes(boxes);
    }

    /**
     * accessor method for Puzzle boxes
     * @return Box array of Puzzle boxes
     */
    public Box[] getBoxes(){
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
     * @throws NullPointerException if Box not found in Puzzle
     */
    public Box getBox(int num){
        if(num < 1 || num > 9) throw new IllegalArgumentException("invalid Box number");
        int[] rowSearch = new int[3], colSearch = new int[3];
        switch(num){
            case 1:
                rowSearch = new int[]{1,2,3};
                colSearch = new int[]{1,2,3};
                break;
            case 2:
                rowSearch = new int[]{1,2,3};
                colSearch = new int[]{4,5,6};
                break;
            case 3:
                rowSearch = new int[]{1,2,3};
                colSearch = new int[]{7,8,9};
                break;
            case 4:
                rowSearch = new int[]{4,5,6};
                colSearch = new int[]{1,2,3};
                break;
            case 5:
                rowSearch = new int[]{4,5,6};
                colSearch = new int[]{4,5,6};
                break;
            case 6:
                rowSearch = new int[]{4,5,6};
                colSearch = new int[]{7,8,9};
                break;
            case 7:
                rowSearch = new int[]{7,8,9};
                colSearch = new int[]{1,2,3};
                break;
            case 8:
                rowSearch = new int[]{7,8,9};
                colSearch = new int[]{4,5,6};
                break;
            case 9:
                rowSearch = new int[]{7,8,9};
                colSearch = new int[]{7,8,9};
                break;
        }
        for(Box b : this.getBoxes()){
            int[] r = b.getRowNums(), c = b.getColNums();
            if(Arrays.equals(r, rowSearch) && Arrays.equals(c, colSearch)) return b;
        }

        throw new NullPointerException("error");
    }

    /**
     * get column of values from Puzzle
     * @param num desired column
     * @throws IllegalArgumentException if desired column < 1 or > 9
     * @throws NullPointerException if column not found in Puzzle
     * @return array of values in Puzzle column
     */
    public int[] getColVals(int num){
        Cell[] cellArr = this.getCol(num);
        int[] valArr = new int[cellArr.length];
        for(int i = 0; i < cellArr.length; i++) valArr[i] = cellArr[i].getVal();
        return valArr;
    }

    /**
     * get column of values from Puzzle
     * @param num desired column
     * @throws IllegalArgumentException if desired column < 1 or > 9
     * @throws NullPointerException if column not found in Puzzle
     * @return array of Cells in Puzzle column
     */
    private Cell[] getCol(int num){
        if(num < 1 || num > 9) throw new IllegalArgumentException("invalid column number");
        List<Cell> cells = new ArrayList<>();
        List<Cell> cellsOut = new ArrayList<>();
        for(Box b : this.getBoxes()){
            for(Cell c : b.getCells()) cells.add(c);
        }
        for(Cell c : cells){
            if(c.getCol() == num) cellsOut.add(c);
        }
        return cellsOut.toArray(new Cell[0]);
    }

    /**
     * get row of values from Puzzle
     * @param num desired row
     * @throws IllegalArgumentException if desired row < 1 or > 9
     * @throws NullPointerException if row not found in Puzzle
     * @return array of values in Puzzle row
     */
    public int[] getRowVals(int num){
        Cell[] cellArr = this.getRow(num);
        int[] valArr = new int[cellArr.length];
        for(int i = 0; i < cellArr.length; i++) valArr[i] = cellArr[i].getVal();
        return valArr;
    }

    /**
     * get row of values from Puzzle
     * @param num desired row
     * @throws IllegalArgumentException if desired row < 1 or > 9
     * @throws NullPointerException if row not found in Puzzle
     * @return array of Cells in Puzzle row
     */
    private Cell[] getRow(int num){
        if(num < 1 || num > 9) throw new IllegalArgumentException("invalid row number");
        List<Cell> cells = new ArrayList<>();
        List<Cell> cellsOut = new ArrayList<>();
        for(Box b : this.getBoxes()){
            for(Cell c : b.getCells()) cells.add(c);
        }
        for(Cell c : cells){
            if(c.getRow() == num) cellsOut.add(c);
        }
        return cellsOut.toArray(new Cell[0]);
    }

    /**
     * Get Cell at specified row and column
     * @param r desired row
     * @param c desired column
     * @return Cell at (r, c) in Puzzle
     * @throws IllegalArgumentException if desired row or column are invalid
     * @throws NullPointerException if desired Cell not found
     */
    public Cell getCell(int r, int c){

        if(!Cell.isValidRow(r) || !Cell.isValidCol(c)) throw new IllegalArgumentException("row or column not valid");
        Cell[] row = this.getRow(r);
        for(Cell cell : row){
            if(cell.getCol() == c) return cell;
        }

        throw new NullPointerException("Cell not found in Puzzle");

    }

    /**
     * Get Cell at specified row and column
     * @param r desired row
     * @param c desired column
     * @return Cell at (r, c) in Puzzle
     * @throws IllegalArgumentException if desired row or column are invalid
     * @throws NullPointerException if desired Cell not found
     */
    public void setCell(int r, int c, int v){
        if(this.getCell(r,c) == null) throw new NullPointerException("Cell not found in Puzzle");
        this.getCell(r,c).setVal(v);
    }

    /**
     * mutator method for the Box array of the Puzzle
     * @param boxes the desired Box array
     * @throws IllegalArgumentException if the Box array is invalid
     */
    private void setBoxes(Box[] boxes){
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

    /**
     * sets the values in a desired row
     * @param r desired row
     * @param vals desired values
     * @throws IllegalArgumentException if any arguments are invalid
     * @throws NullPointerException if row cannot be found
     */
    public void setRow(int r, int[] vals){}

    /**
     * sets the values in a desired column
     * @param c desired column
     * @param cols desired values
     * @throws IllegalArgumentException if any arguments are invalid
     * @throws NullPointerException if column cannot be found
     */
    public void setCol(int c, int[] cols){}

}
