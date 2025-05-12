package com.mycompany.xo_game;

public class Board implements BoardInterface {
    private char[][] arr;

    public Board() {
        arr = new char[][] { {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'} };
    }

    public int getRow(int index) {
        return (index - 1) / 3;
    }

    public int getCol(int index) {
        return (index - 1) % 3;
    }

    public boolean isEmpty(int index) {
        if (index < 1 || index > 9) return false;
        int row = getRow(index);
        int col = getCol(index);
        char c = Character.toLowerCase(arr[row][col]);
        return !(c == 'x' || c == 'o');
    }

    public boolean replaceChar(int index, Player p) {
        if (isEmpty(index)) {
            int row = getRow(index);
            int col = getCol(index);
            arr[row][col] = p.getOp();
            return true;
        }
        return false;
    }

    public void draw() {
        System.out.println("------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }

    public boolean isFull() {
        for (int i = 1; i <= 9; i++) {
            if (isEmpty(i)) return false;
        }
        return true;
    }

    @Override
    public boolean isWin(Player p) {
        char op = Character.toLowerCase(p.getOp());
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if ((Character.toLowerCase(arr[i][0]) == op && Character.toLowerCase(arr[i][1]) == op && Character.toLowerCase(arr[i][2]) == op) ||
                (Character.toLowerCase(arr[0][i]) == op && Character.toLowerCase(arr[1][i]) == op && Character.toLowerCase(arr[2][i]) == op)) {
                return true;
            }
        }
        // Diagonals
        if ((Character.toLowerCase(arr[0][0]) == op && Character.toLowerCase(arr[1][1]) == op && Character.toLowerCase(arr[2][2]) == op) ||
            (Character.toLowerCase(arr[0][2]) == op && Character.toLowerCase(arr[1][1]) == op && Character.toLowerCase(arr[2][0]) == op)) {
            return true;
        }
        return false;
    }
}
