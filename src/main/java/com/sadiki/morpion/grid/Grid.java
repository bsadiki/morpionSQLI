package com.sadiki.morpion.grid;

import com.sadiki.morpion.grid.box.Box;
import com.sadiki.morpion.pair.Pair;

public class Grid {
    private final Box[][] boxesMatrix;
    private final Verifier verifier;

    Grid(Box[][] boxesMatrix, Verifier verifier) {
        this.boxesMatrix = boxesMatrix;
        this.verifier = verifier;
    }

    public Box getBox(Pair pair) {
        return boxesMatrix[pair.x][pair.y];
    }

    public boolean gameIsOver() {
        return gridIsFull() || gameIsWon();
    }

    public boolean gameIsWon() {
        return verifier.gameIsWon(boxesMatrix);
    }

    private boolean gridIsFull() {
        return remainingEmptyBoxes() == 0;
    }

    public int remainingEmptyBoxes() {
        int remainingEmptyBoxes = 0;
        for (Box[] boxes : boxesMatrix) {
            for (Box box : boxes) {
                if (!box.isSelected()) {
                    remainingEmptyBoxes++;
                }
            }
        }
        return remainingEmptyBoxes;
    }

    public String winingSymbol() {
        return verifier.winner(boxesMatrix);
    }

    public String display(Displayer displayer) {
        return displayer.display(boxesMatrix);
    }
}
