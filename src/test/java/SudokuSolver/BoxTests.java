package SudokuSolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTests {

    @Test
    // isValidCellArray method tests
    void isValidCellArrayTests(){
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
        Cell[] a1, a2, a3, a4, a5, a6, a7, a8;
        a1 = new Cell[]{};
        assertThrows(IllegalArgumentException.class, ()-> new Box(a1));
        a2 = new Cell[1];
        assertThrows(IllegalArgumentException.class, ()-> new Box(a2));
        a3 = new Cell[8];
        assertThrows(IllegalArgumentException.class, ()-> new Box(a3));
        a4 = new Cell[10];
        assertThrows(IllegalArgumentException.class, ()-> new Box(a4));
        a5 = new Cell[100];
        assertThrows(IllegalArgumentException.class, ()-> new Box(a5));
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
        assertThrows(IllegalArgumentException.class, ()-> new Box(a6));
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
        assertThrows(IllegalArgumentException.class, ()-> new Box(a7));
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
        Box b = new Box(a8);
        assertArrayEquals(a8, b.getCells());
        assertFalse(b.getComplete());
    }

    @Test
    // getCell method tests
    void getCellTests(){
        Cell[] a1 = new Cell[]{
                new Cell(1, 1, 1),
                new Cell(2, 1, 2),
                new Cell(3, 1, 3),
                new Cell(4, 2, 1),
                new Cell(5, 2, 2),
                new Cell(6, 2, 3),
                new Cell(7, 3, 1),
                new Cell(8, 3, 2),
                new Cell(9, 3, 3)
        };
        Box b1 = new Box(a1);
        assertThrows(IllegalArgumentException.class, ()-> b1.getCell(-10, -10));
        assertThrows(IllegalArgumentException.class, ()-> b1.getCell(0, 0));
        assertThrows(IllegalArgumentException.class, ()-> b1.getCell(1, 0));
        assertThrows(IllegalArgumentException.class, ()-> b1.getCell(0, 1));
        assertThrows(NullPointerException.class, ()-> b1.getCell(4,1));
        assertThrows(NullPointerException.class, ()-> b1.getCell(2,4));
        assertThrows(IllegalArgumentException.class, ()-> b1.getCell(10,10));
        assertEquals(a1[0].getVal(), b1.getCell(1,1).getVal());
        assertEquals(a1[1].getVal(), b1.getCell(1,2).getVal());
        assertEquals(a1[2].getVal(), b1.getCell(1,3).getVal());
        assertEquals(a1[3].getVal(), b1.getCell(2,1).getVal());
        assertEquals(a1[4].getVal(), b1.getCell(2,2).getVal());
        assertEquals(a1[5].getVal(), b1.getCell(2,3).getVal());
        assertEquals(a1[6].getVal(), b1.getCell(3,1).getVal());
        assertEquals(a1[7].getVal(), b1.getCell(3,2).getVal());
        assertEquals(a1[8].getVal(), b1.getCell(3,3).getVal());
    }

    @Test
    // setCell method tests
    void setCellTests(){
        Cell[] a1 = new Cell[]{
                new Cell(1, 1, 1),
                new Cell(2, 1, 2),
                new Cell(3, 1, 3),
                new Cell(4, 2, 1),
                new Cell(5, 2, 2),
                new Cell(6, 2, 3),
                new Cell(7, 3, 1),
                new Cell(8, 3, 2),
                new Cell(9, 3, 3)
        };
        Box b1 = new Box(a1);
        assertThrows(NullPointerException.class, ()-> b1.setCell(4,1,8));
        assertThrows(IllegalArgumentException.class, ()-> b1.setCell(10,1,3));
        assertThrows(IllegalArgumentException.class, ()-> b1.setCell(10,1,3));
        b1.setCell(1, 1, 9);
        assertEquals(9, b1.getCell(1,1).getVal());
        b1.setCell(1, 2, 8);
        assertEquals(8, b1.getCell(1,2).getVal());
        b1.setCell(1, 3, 7);
        assertEquals(7, b1.getCell(1,3).getVal());
        b1.setCell(2, 1, 6);
        assertEquals(6, b1.getCell(2,1).getVal());
        b1.setCell(2, 2, 5);
        assertEquals(5, b1.getCell(2,2).getVal());
        b1.setCell(2, 3, 4);
        assertEquals(4, b1.getCell(2,3).getVal());
        b1.setCell(3, 1, 3);
        assertEquals(3, b1.getCell(3,1).getVal());
        b1.setCell(3, 2, 2);
        assertEquals(2, b1.getCell(3,2).getVal());
        b1.setCell(3, 3, 1);
        assertEquals(1, b1.getCell(3,3).getVal());
    }

    @Test
    // checkComplete method tests
    void checkCompleteTests(){
        Cell[] a1 = new Cell[]{
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
        Box b1 = new Box(a1);
        assertFalse(b1.getComplete());
        Cell[] a2 = new Cell[]{
                new Cell(1, 1, 1),
                new Cell(2, 1, 2),
                new Cell(3, 1, 3),
                new Cell(4, 2, 1),
                new Cell(5, 2, 2),
                new Cell(6, 2, 3),
                new Cell(7, 3, 1),
                new Cell(8, 3, 2),
                new Cell(9, 3, 3)
        };
        Box b2 = new Box(a2);
        assertTrue(b2.getComplete());
    }

    @Test
    // getColNums method tests
    void getColNumsTests(){
        // TODO: implement
        Box b1, b2;
        Cell[] a1 = new Cell[]{
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
        b1 = new Box(a1);
        assertArrayEquals(new int[]{1, 2, 3}, b1.getColNums());
        Cell[] a2 = new Cell[]{
                new Cell(1, 1, 7),
                new Cell(2, 1, 8),
                new Cell(3, 1, 9),
                new Cell(4, 2, 7),
                new Cell(5, 2, 8),
                new Cell(6, 2, 9),
                new Cell(7, 3, 7),
                new Cell(8, 3, 8),
                new Cell(9, 3, 9)
        };
        b2 = new Box(a2);
        assertArrayEquals(new int[]{7, 8, 9}, b2.getColNums());
    }

    @Test
    // getRowNums method tests
    void getRowNumsTests(){
        // TODO: implement
        Box b1, b2;
        Cell[] a1 = new Cell[]{
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
        b1 = new Box(a1);
        assertArrayEquals(new int[]{1, 2, 3}, b1.getRowNums());
        Cell[] a2 = new Cell[]{
                new Cell(1, 4, 1),
                new Cell(2, 4, 2),
                new Cell(3, 4, 3),
                new Cell(4, 5, 1),
                new Cell(5, 5, 2),
                new Cell(6, 5, 3),
                new Cell(7, 6, 1),
                new Cell(8, 6, 2),
                new Cell(9, 6, 3)
        };
        b2 = new Box(a2);
        assertArrayEquals(new int[]{4, 5, 6}, b2.getRowNums());
    }

}
