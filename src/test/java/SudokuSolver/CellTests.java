package SudokuSolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import SudokuSolver.Cell;

public class CellTests {

    /**
     * isValidVal method tests
     */
    @Test
    void isValidValTests(){
        // these should return false: i < 1 or i > 9 for int i;
        assertFalse(Cell.isValidVal(-100));
        assertFalse(Cell.isValidVal(-1));
        assertFalse(Cell.isValidVal(0));
        assertFalse(Cell.isValidVal(10));
        assertFalse(Cell.isValidVal(11));
        assertFalse(Cell.isValidVal(100));

        // these should return true: i > 0 and i < 10 for int i;
        assertTrue(Cell.isValidVal(1));
        assertTrue(Cell.isValidVal(2));
        assertTrue(Cell.isValidVal(5));
        assertTrue(Cell.isValidVal(8));
        assertTrue(Cell.isValidVal(9));
    }

    /**
     * isValidRow method tests
     */
    @Test
    void isValidRowTests(){
        // these should return false: i < 1 or i > 9 for int i;
        assertFalse(Cell.isValidRow(-100));
        assertFalse(Cell.isValidRow(-1));
        assertFalse(Cell.isValidRow(0));
        assertFalse(Cell.isValidRow(10));
        assertFalse(Cell.isValidRow(11));
        assertFalse(Cell.isValidRow(100));

        // these should return true: i > 0 and i < 10 for int i;
        assertTrue(Cell.isValidRow(1));
        assertTrue(Cell.isValidRow(2));
        assertTrue(Cell.isValidRow(5));
        assertTrue(Cell.isValidRow(8));
        assertTrue(Cell.isValidRow(9));    }

    /**
     * isValidCol method tests
     */
    @Test
    void isValidColTests(){
        // these should return false: i < 1 or i > 9 for int i;
        assertFalse(Cell.isValidCol(-100));
        assertFalse(Cell.isValidCol(-1));
        assertFalse(Cell.isValidCol(0));
        assertFalse(Cell.isValidCol(10));
        assertFalse(Cell.isValidCol(11));
        assertFalse(Cell.isValidCol(100));

        // these should return true: i > 0 and i < 10 for int i;
        assertTrue(Cell.isValidCol(1));
        assertTrue(Cell.isValidCol(2));
        assertTrue(Cell.isValidCol(5));
        assertTrue(Cell.isValidCol(8));
        assertTrue(Cell.isValidCol(9));
    }

    @Test
    /**
     * constructor, accessor, and mutator methods tests
     */
    void constructorTests(){
        // TODO: implement tests
        assertTrue(false);
    }

}
