package ru.poletskiy.se.lesson14;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testGetMaxCharRepeat() {
        int maxCharRepeat;
        maxCharRepeat = Tictactoe.getMaxCharRepeat("...", 'X');
        assertEquals( 0,  maxCharRepeat );
        maxCharRepeat = Tictactoe.getMaxCharRepeat("XOO", 'X');
        assertEquals( 1,  maxCharRepeat );
        maxCharRepeat = Tictactoe.getMaxCharRepeat("XXO", 'X');
        assertEquals( 2,  maxCharRepeat );
        maxCharRepeat = Tictactoe.getMaxCharRepeat("XXX", 'X');
        assertEquals( 3,  maxCharRepeat );
        maxCharRepeat = Tictactoe.getMaxCharRepeat("XOXXXXOX", 'X');
        assertEquals( 4,  maxCharRepeat );
        maxCharRepeat = Tictactoe.getMaxCharRepeat("", 'X');
        assertEquals( 0,  maxCharRepeat );
    }
//    @Test
//    public void testIsGameOver() {
//        char[][] map1 = new char[][]{};
//        char[][] map2 = new char[][]{};
//        for (int i = 0; i < Tictactoe.MAP_SIZE; i++) {
//            for (int j = 0; j < Tictactoe.MAP_SIZE; j++) {
//                map1[i][j] = '.';
//                map2[i][j] = 'X';
//            }
//        }
//        Tictactoe.initGame();
//        Tictactoe.map = map1;
//        assertFalse(Tictactoe.isGameOver());
//        Tictactoe.map = map2;
//        assertTrue(Tictactoe.isGameOver());
//    }
}
