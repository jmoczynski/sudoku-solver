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
