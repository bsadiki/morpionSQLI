package com.sadiki.morpion.players;

import com.sadiki.morpion.grid.box.Box;

public class Player {
    private final String name;
    private final String symbol;

    Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    String getName() {
        return name;
    }

    void play(Box box) {
        box.play(symbol);
    }
    boolean hasSameSymbol(String symbol){
        return this.symbol.equals(symbol);
    }
}
