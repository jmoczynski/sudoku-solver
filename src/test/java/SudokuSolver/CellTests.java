package SudokuSolver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTests {

    // isValidVal method tests
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

    // isValidRow method tests
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

    // isValidCol method tests
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
    // constructor, accessor, and mutator methods tests
    void constructorTests(){
        int[] s1, s2;
        s1 = new int[]{-100, -1, 0, 10, 11, 100};
        s2 = new int[]{1, 2, 5, 8, 9};

        // constructor tests
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[0],s2[0],s2[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[1],s2[0],s2[1]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[2],s2[0],s2[2]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[3],s2[1],s2[3]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[4],s2[1],s2[4]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s1[5],s2[1],s2[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[0],s1[0],s2[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[1],s1[1],s2[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[2],s1[2],s2[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[3],s1[3],s2[1]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[4],s1[4],s2[1]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[0],s1[5],s2[1]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[0],s2[0],s1[0]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[0],s2[1],s1[1]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[0],s2[2],s1[2]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[1],s2[3],s1[3]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[1],s2[4],s1[4]));
        assertThrows(IllegalArgumentException.class, ()-> new Cell(s2[1],s2[0],s1[5]));

        Cell c1, c2, c3;
        c1 = new Cell(1, 1, 1);
        assertNotNull(c1);
        c2 = new Cell(2, 5, 8);
        assertNotNull(c2);
        c3 = new Cell(9,5,1);
        assertNotNull(c3);

        // accessor tests
        assertEquals(1, c1.getVal());
        assertEquals(1, c1.getRow());
        assertEquals(1, c1.getCol());
        assertEquals(2, c2.getVal());
        assertEquals(5, c2.getRow());
        assertEquals(8, c2.getCol());
        assertEquals(9, c3.getVal());
        assertEquals(5, c3.getRow());
        assertEquals(1, c3.getCol());
        assertEquals(c1.getCol(), c3.getCol());
        assertEquals(c2.getRow(), c3.getRow());

        // mutator tests
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[0]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[1]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[2]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[3]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[4]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setVal(s1[5]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[0]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[1]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[2]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[3]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[4]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setRow(s1[5]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[0]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[1]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[2]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[3]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[4]));
        assertThrows(IllegalArgumentException.class, ()-> c1.setCol(s1[5]));
    }

}
