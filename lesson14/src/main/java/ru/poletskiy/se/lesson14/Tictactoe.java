package ru.poletskiy.se.lesson14;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Tic tac toe game
 *
 */

public class Tictactoe {
    public static char[][] map;
    final public static char DOT_X = 'X';
    final public static char DOT_O = 'O';
    final public static char DOT_EMPTY = '.';
    final public static int MAP_SIZE = 5;
    final public static int WIN_LINE_LENGTH = 3;

    public static void main( String[] args )
    {
        initGame();
        printMap();
        while (true) {
            playersMove();
            if (isVictory(DOT_X)) {
                System.out.println("Игрок выиграл!");
                break;
            }
            if (isGameOver()) {
                System.out.println("Ничья!");
                break;
            }
            computersMove();
            if (isVictory(DOT_O)) {
                System.out.println("Компьютер выиграл!");
                break;
            }
            if (isGameOver()) {
                System.out.println("Ничья!");
                break;
            }
            printMap();
        }
        printMap();
    }

    public static void initGame() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        System.out.print(" ");
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void playersMove() {
        final Scanner scanner = new Scanner(System.in);
        int coordinateX;
        int coordinateY;
        System.out.println("Ваш ход:");
        do {
            System.out.println("Введите координату X");
            coordinateX = scanner.nextInt();
            System.out.println("Введите координату У");
            coordinateY = scanner.nextInt();
        } while (!isMoveValid(coordinateX, coordinateY));
        map[coordinateX - 1][coordinateY - 1] = DOT_X;
    }
    public static void computersMove() {
        final Random randomInt = new Random();
        int coordinateX;
        int coordinateY;
        do {
            coordinateX = randomInt.nextInt(MAP_SIZE + 1);
            coordinateY = randomInt.nextInt(MAP_SIZE + 1);
        } while (!isMoveValid(coordinateX, coordinateY));
        map[coordinateX - 1][coordinateY - 1] = DOT_O;
    }
    public static boolean isMoveValid(int X, int Y) {
        if (X < 1 || X > MAP_SIZE || Y < 1 || Y > MAP_SIZE) return false;
        if (map[X - 1][Y - 1] != DOT_EMPTY) return false;
        return true;
    }
    public static boolean isVictory(char dot) {
        final ArrayList<String> mapLines = getMapLinesArray();
        int maxCharRepeat;
        for (String line:mapLines) {
            maxCharRepeat = getMaxCharRepeat(line, dot);
            if (maxCharRepeat >= WIN_LINE_LENGTH) return true;
        }
        return false;
    }
    public static boolean isGameOver() {
        for (int i = 0; i < MAP_SIZE; i++)
            for (int j = 0; j < MAP_SIZE; j++)
                if (map[i][j] == DOT_EMPTY) return false;
        return true;
    }
    public static ArrayList getMapLinesArray() {
        String lineX = new String();
        String lineY = new String();
        String upDiagonal = new String();
        String downDiagonal = new String();
        ArrayList lines = new ArrayList();
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                lineX += map[i][j];
                lineY += map[j][i];
                if (i == j) downDiagonal += map[i][j];
                if (i + j == MAP_SIZE - 1) upDiagonal += map[i][j];
            }
            lines.add(lineX);
            lines.add(lineY);
            lineX = "";
            lineY = "";
        }
        lines.add(downDiagonal);
        lines.add(upDiagonal);
        return lines;
    }
    public static int getMaxCharRepeat(String str, char finded_char) {
        int repeatCount = 0;
        int maxRepeatCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == finded_char) {
                repeatCount++;
                if (repeatCount > maxRepeatCount) maxRepeatCount = repeatCount;
            } else {
                repeatCount = 0;
            }
        }
        return maxRepeatCount;
    }
}