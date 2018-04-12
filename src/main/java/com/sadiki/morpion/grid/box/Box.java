package com.sadiki.morpion.grid.box;

public class Box {
    private static final String EMPTY = " ";
    private String symbol;

    public Box() {
        this.symbol = EMPTY;
    }

    public void play(String symbol) {
        if (isSelected())
            throw new BoxAlreadySelectedException();
        else
            this.symbol = symbol;
    }

    public boolean isSelected() {
        return !this.symbol.equals(EMPTY);
    }

    public String display() {
        return symbol;
    }

    public boolean hasSameSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
