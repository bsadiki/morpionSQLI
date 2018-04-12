package com.sadiki.morpion.grid;

import com.sadiki.morpion.grid.box.Box;
import com.sadiki.morpion.pair.Pair;
import com.sadiki.morpion.pair.PairFactory;

public class GridFactory {
    private Box[][] boxesMatrix;
    public Grid createFrom(String dimension) {
        Pair pair = new PairFactory().createPair(dimension);
        initMatrix(pair);
        Extractor extractor = new Extractor();
        Verifier verifier= new Verifier(extractor);
        return new Grid(boxesMatrix,verifier);
    }
    private void initMatrix(Pair pair){
        boxesMatrix = new Box[pair.x][pair.y];
        for (Box[] boxes : boxesMatrix){
            for (int i = 0; i < boxes.length; i++)
                boxes[i] = new Box();
        }
    }
}
