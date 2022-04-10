package SudokuSolver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PuzzleTests {

    @Test
    // isValidBoxArray method tests
    void isValidBoxArrayTests(){
        Box[] b1, b2, b3, b4, b5, b6;
        b1 = new Box[0];
        b2 = new Box[1];
        b3 = new Box[8];
        b4 = new Box[9];
        b5 = new Box[10];
        b6 = new Box[100];
        assertFalse(Puzzle.isValidBoxArray(b1));
        assertFalse(Puzzle.isValidBoxArray(b2));
        assertFalse(Puzzle.isValidBoxArray(b3));
        assertFalse(Puzzle.isValidBoxArray(b5));
        assertFalse(Puzzle.isValidBoxArray(b6));
        assertFalse(Puzzle.isValidBoxArray(b4));

        Cell[] cells1, cells2, cells3, cells4, cells5, cells6, cells7, cells8, cells9;
        cells1 = new Cell[]{
                new Cell(0,1,1),
                new Cell(0,1,2),
                new Cell(0,1,3),
                new Cell(0,2,1),
                new Cell(0,2,2),
                new Cell(0,2,3),
                new Cell(0,3,1),
                new Cell(0,3,2),
                new Cell(0,3,3)
        };
        cells2 = new Cell[]{
                new Cell(0,1,4),
                new Cell(0,1,5),
                new Cell(0,1,6),
                new Cell(0,2,4),
                new Cell(0,2,5),
                new Cell(0,2,6),
                new Cell(0,3,4),
                new Cell(0,3,5),
                new Cell(0,3,6)
        };
        cells3 = new Cell[]{
                new Cell(0,1,7),
                new Cell(0,1,8),
                new Cell(0,1,9),
                new Cell(0,2,7),
                new Cell(0,2,8),
                new Cell(0,2,9),
                new Cell(0,3,7),
                new Cell(0,3,8),
                new Cell(0,3,9)
        };
        cells4 = new Cell[]{
                new Cell(0,4,1),
                new Cell(0,4,2),
                new Cell(0,4,3),
                new Cell(0,5,1),
                new Cell(0,5,2),
                new Cell(0,5,3),
                new Cell(0,6,1),
                new Cell(0,6,2),
                new Cell(0,6,3)
        };
        cells5 = new Cell[]{
                new Cell(0,4,7),
                new Cell(0,4,8),
                new Cell(0,4,9),
                new Cell(0,5,7),
                new Cell(0,5,8),
                new Cell(0,5,9),
                new Cell(0,6,7),
                new Cell(0,6,8),
                new Cell(0,6,9)
        };
        cells6 = new Cell[]{
                new Cell(0,4,4),
                new Cell(0,4,5),
                new Cell(0,4,6),
                new Cell(0,5,4),
                new Cell(0,5,5),
                new Cell(0,5,6),
                new Cell(0,6,4),
                new Cell(0,6,5),
                new Cell(0,6,6)
        };
        cells7 = new Cell[]{
                new Cell(0,7,4),
                new Cell(0,7,5),
                new Cell(0,7,6),
                new Cell(0,8,4),
                new Cell(0,8,5),
                new Cell(0,8,6),
                new Cell(0,9,4),
                new Cell(0,9,5),
                new Cell(0,9,6)
        };
        cells8 = new Cell[]{
                new Cell(0,7,7),
                new Cell(0,7,8),
                new Cell(0,7,9),
                new Cell(0,8,7),
                new Cell(0,8,8),
                new Cell(0,8,9),
                new Cell(0,9,7),
                new Cell(0,9,8),
                new Cell(0,9,9)
        };
        cells9 = new Cell[]{
                new Cell(0,7,1),
                new Cell(0,7,2),
                new Cell(0,7,3),
                new Cell(0,8,1),
                new Cell(0,8,2),
                new Cell(0,8,3),
                new Cell(0,9,1),
                new Cell(0,9,2),
                new Cell(0,9,3)
        };
        Box bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc9;
        bc1 = new Box(cells1);
        bc2 = new Box(cells2);
        bc3 = new Box(cells3);
        bc4 = new Box(cells4);
        bc5 = new Box(cells5);
        bc6 = new Box(cells6);
        bc7 = new Box(cells7);
        bc8 = new Box(cells8);
        bc9 = new Box(cells9);
        Box[] ta1, ta2;
        ta1 = new Box[]{bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc8};
        assertFalse(Puzzle.isValidBoxArray(ta1));
        ta2 = new Box[]{bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc9};
        assertTrue(Puzzle.isValidBoxArray(ta2));

    }

    @Test
    // constructor, accessor, mutator methods tests
    void constructorTests(){
        Cell[] cells1, cells2, cells3, cells4, cells5, cells6, cells7, cells8, cells9;
        cells1 = new Cell[]{
                new Cell(0,1,1),
                new Cell(0,1,2),
                new Cell(0,1,3),
                new Cell(0,2,1),
                new Cell(0,2,2),
                new Cell(0,2,3),
                new Cell(0,3,1),
                new Cell(0,3,2),
                new Cell(0,3,3)
        };
        cells2 = new Cell[]{
                new Cell(0,1,4),
                new Cell(0,1,5),
                new Cell(0,1,6),
                new Cell(0,2,4),
                new Cell(0,2,5),
                new Cell(0,2,6),
                new Cell(0,3,4),
                new Cell(0,3,5),
                new Cell(0,3,6)
        };
        cells3 = new Cell[]{
                new Cell(0,1,7),
                new Cell(0,1,8),
                new Cell(0,1,9),
                new Cell(0,2,7),
                new Cell(0,2,8),
                new Cell(0,2,9),
                new Cell(0,3,7),
                new Cell(0,3,8),
                new Cell(0,3,9)
        };
        cells4 = new Cell[]{
                new Cell(0,4,1),
                new Cell(0,4,2),
                new Cell(0,4,3),
                new Cell(0,5,1),
                new Cell(0,5,2),
                new Cell(0,5,3),
                new Cell(0,6,1),
                new Cell(0,6,2),
                new Cell(0,6,3)
        };
        cells5 = new Cell[]{
                new Cell(0,4,7),
                new Cell(0,4,8),
                new Cell(0,4,9),
                new Cell(0,5,7),
                new Cell(0,5,8),
                new Cell(0,5,9),
                new Cell(0,6,7),
                new Cell(0,6,8),
                new Cell(0,6,9)
        };
        cells6 = new Cell[]{
                new Cell(0,4,4),
                new Cell(0,4,5),
                new Cell(0,4,6),
                new Cell(0,5,4),
                new Cell(0,5,5),
                new Cell(0,5,6),
                new Cell(0,6,4),
                new Cell(0,6,5),
                new Cell(0,6,6)
        };
        cells7 = new Cell[]{
                new Cell(0,7,4),
                new Cell(0,7,5),
                new Cell(0,7,6),
                new Cell(0,8,4),
                new Cell(0,8,5),
                new Cell(0,8,6),
                new Cell(0,9,4),
                new Cell(0,9,5),
                new Cell(0,9,6)
        };
        cells8 = new Cell[]{
                new Cell(0,7,7),
                new Cell(0,7,8),
                new Cell(0,7,9),
                new Cell(0,8,7),
                new Cell(0,8,8),
                new Cell(0,8,9),
                new Cell(0,9,7),
                new Cell(0,9,8),
                new Cell(0,9,9)
        };
        cells9 = new Cell[]{
                new Cell(0,7,1),
                new Cell(0,7,2),
                new Cell(0,7,3),
                new Cell(0,8,1),
                new Cell(0,8,2),
                new Cell(0,8,3),
                new Cell(0,9,1),
                new Cell(0,9,2),
                new Cell(0,9,3)
        };
        Box bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc9;
        bc1 = new Box(cells1);
        bc2 = new Box(cells2);
        bc3 = new Box(cells3);
        bc4 = new Box(cells4);
        bc5 = new Box(cells5);
        bc6 = new Box(cells6);
        bc7 = new Box(cells7);
        bc8 = new Box(cells8);
        bc9 = new Box(cells9);
        assertThrows(IllegalArgumentException.class, ()-> new Puzzle(new Box[]{bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc8}));
        Puzzle p1 = new Puzzle(new Box[]{bc1, bc2, bc3, bc4, bc5, bc6, bc7, bc8, bc9});
    }
}
