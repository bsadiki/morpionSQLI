package com.sadiki.morpion.grid;

import com.sadiki.morpion.grid.box.Box;

class Extractor {
    Box[][] extractColumns(Box[][] initialBoxesMatrix) {
        Box[][] extractedColumns = new Box[initialBoxesMatrix[0].length][initialBoxesMatrix.length];
        for (int i = 0; i < initialBoxesMatrix.length; i++) {
            for (int j = 0; j < initialBoxesMatrix[0].length; j++)
                extractedColumns[j][i] = initialBoxesMatrix[i][j];
        }
        return extractedColumns;
    }

    Box[][] extractDiagonals(Box[][] initialBoxesMatrix) {
        Box[][] extractedDiagonals = new Box[2][initialBoxesMatrix.length];
        extractedDiagonals[0] = extractFirstDiagonal(initialBoxesMatrix);
        extractedDiagonals[1] = extractSecondDiagonal(initialBoxesMatrix);
        return extractedDiagonals;
    }

    private Box[] extractFirstDiagonal(Box[][] initialBoxesMatrix) {
        Box[] firstDiagonal = new Box[initialBoxesMatrix.length];
        for (int i = 0; i < initialBoxesMatrix.length; i++) {
            firstDiagonal[i] = initialBoxesMatrix[i][i];
        }
        return firstDiagonal;
    }
    private Box[] extractSecondDiagonal(Box[][] initialBoxesMatrix) {
        Box[] secondDiagonal = new Box[initialBoxesMatrix.length];
        for (int i = 0; i < initialBoxesMatrix.length; i++) {
            secondDiagonal[i] = initialBoxesMatrix[initialBoxesMatrix.length-i-1][i];
        }
        return secondDiagonal;
    }
}
