package com.mycompany.xo_game;

public class Player {
    private String name;
    private char op;

    public Player() {}

    public Player(String name, char op) {
        this.name = name;
        this.op = op;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }
}
