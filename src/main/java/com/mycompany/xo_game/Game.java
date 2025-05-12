package com.mycompany.xo_game;

import java.util.Scanner;

public class Game {
    private Board myBoard = new Board();
    private Player p1 = new Player();
    private Player p2 = new Player();
    private int counter = 0;
    private Scanner input = new Scanner(System.in);

    private String readPlayerName(int playerNum) {
        System.out.print("Enter player " + playerNum + " name: ");
        return input.nextLine();
    }

    private char readPlayerOp() {
        while (true) {
            System.out.print("Select Player 1 Operator 'x' or 'o': ");
            String opInput = input.nextLine().trim().toLowerCase();
            if (opInput.length() == 1 && (opInput.charAt(0) == 'x' || opInput.charAt(0) == 'o')) {
                return opInput.charAt(0);
            }
            System.out.println("Invalid input. Please enter only 'x' or 'o'.");
        }
    }

    private int readPosition(Player currentPlayer) {
        while (true) {
            System.out.print(currentPlayer.getName() + ", select empty position (1-9): ");
            if (input.hasNextInt()) {
                int pos = input.nextInt();
                input.nextLine(); // consume leftover newline
                if (myBoard.replaceChar(pos, currentPlayer)) {
                    return pos;
                }
            } else {
                input.nextLine(); // discard invalid input
            }
            System.out.println("Invalid or occupied position. Try again.");
        }
    }

    public void readPlayerData() {
        p1.setName(readPlayerName(1));
        p1.setOp(readPlayerOp());

        p2.setName(readPlayerName(2));
        p2.setOp(p1.getOp() == 'x' ? 'o' : 'x');
    }

    public void play() {
        readPlayerData();
        myBoard.draw();

        while (!myBoard.isFull()) {
            Player currentPlayer = (counter % 2 == 0) ? p1 : p2;
            readPosition(currentPlayer);
            myBoard.draw();

            if (myBoard.isWin(currentPlayer)) {
                System.out.println("The winner is: " + currentPlayer.getName());
                return;
            }
            counter++;
        }

        System.out.println("Game is draw..");
    }
}
