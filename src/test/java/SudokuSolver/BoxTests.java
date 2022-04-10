package SudokuSolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTests {

    @Test
    // isValidCellArray method tests
    void isValidCellArrayTests(){
        // TODO: implement tests
        Cell[] a1, a2, a3, a4, a5, a6, a7, a8;
        a1 = new Cell[]{};
        assertFalse(Box.isValidCellArray(a1));
        a2 = new Cell[1];
        assertFalse(Box.isValidCellArray(a2));
        a3 = new Cell[8];
        assertFalse(Box.isValidCellArray(a3));
        a4 = new Cell[10];
        assertFalse(Box.isValidCellArray(a4));
        a5 = new Cell[100];
        assertFalse(Box.isValidCellArray(a5));
        a6 = new Cell[]{
                new Cell(1, 1, 1),
                new Cell(2, 2, 1),
                new Cell(3, 3, 1),
                new Cell(4, 4, 2),
                new Cell(5, 5, 2),
                new Cell(6, 6, 2),
                new Cell(7, 7, 3),
                new Cell(8, 8, 3),
                new Cell(9, 9, 3)
        };
        assertFalse(Box.isValidCellArray(a6));
        a7 = new Cell[]{
                new Cell(1,1,1),
                new Cell(2,1,2),
                new Cell(3,1,3),
                new Cell(4,2,4),
                new Cell(5,2,5),
                new Cell(6,2,6),
                new Cell(7,3,7),
                new Cell(8,3,8),
                new Cell(9,3,9)
        };
        assertFalse(Box.isValidCellArray(a7));
        a8 = new Cell[]{
                new Cell(1, 1, 1),
                new Cell(1, 1, 2),
                new Cell(1, 1, 3),
                new Cell(1, 2, 1),
                new Cell(1, 2, 2),
                new Cell(1, 2, 3),
                new Cell(1, 3, 1),
                new Cell(1, 3, 2),
                new Cell(1, 3, 3)
        };
        assertTrue(Box.isValidCellArray(a8));
    }

    @Test
    // constructor, accessor, and mutator method tests
    void constructorTests(){
        // TODO: implement tests
        assertTrue(false);
    }

    @Test
    // getCell method tests
    void getCellTests(){
        // TODO: implement tests
        assertTrue(false);
    }

    @Test
    // checkComplete method tests
    void checkCompleteTests(){
        // TODO: implement tests
        assertTrue(false);
    }

}
