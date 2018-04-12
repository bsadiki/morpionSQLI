package com.sadiki.morpion.grid;

import com.sadiki.morpion.grid.box.Box;

class Verifier {
    private final Extractor extractor;

    Verifier(Extractor extractor) {
        this.extractor = extractor;
    }

    String winner(Box[][] boxesLines) {
        if (hasIdenticalLine(boxesLines))
            return getWinner(boxesLines);
        if (hasIdenticalColumn(boxesLines))
            return getWinner(extractor.extractColumns(boxesLines));
        if (hasIdenticalDiagonal(boxesLines))
            return getWinner(extractor.extractDiagonals(boxesLines));
        return "";
    }

    private boolean isInAllBoxes(String symbol, Box[] boxes) {
        for (Box box : boxes) {
            if (!box.hasSameSymbol(symbol))
                return false;
        }
        return true;
    }

    boolean gameIsWon(Box[][] boxesMatrix) {
        return hasIdenticalLine(boxesMatrix) || hasIdenticalColumn(boxesMatrix) || hasIdenticalDiagonal(boxesMatrix);
    }

    private boolean hasIdenticalLine(Box[][] boxesMatrix) {
        return !getWinner(boxesMatrix).equals("");
    }

    private boolean hasIdenticalColumn(Box[][] boxesMatrix) {
        Box[][] boxesColumns = extractor.extractColumns(boxesMatrix);
        return !getWinner(boxesColumns).equals("");
    }

    private boolean hasIdenticalDiagonal(Box[][] boxesMatrix) {
        Box[][] boxesDiagonals = extractor.extractDiagonals(boxesMatrix);
        return !getWinner(boxesDiagonals).equals("");
    }

    private String getWinner(Box[][] boxesLines) {
        for (Box[] boxes : boxesLines) {
            String suspectedWinningSymbol = boxes[0].display();
            if (!suspectedWinningSymbol.equals(" ") && isInAllBoxes(suspectedWinningSymbol, boxes))
                return suspectedWinningSymbol;
        }
        return "";
    }
}
