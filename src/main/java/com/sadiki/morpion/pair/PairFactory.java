package com.sadiki.morpion.pair;

public class PairFactory {
    private static final String SEPARATOR = "x";
    public Pair createPair(String pairInfo){
        int x = Integer.parseInt(pairInfo.split(SEPARATOR)[0]);
        int y = Integer.parseInt(pairInfo.split(SEPARATOR)[1]);
        return new Pair(x,y);
    }
}
