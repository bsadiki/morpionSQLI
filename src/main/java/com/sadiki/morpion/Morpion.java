package com.sadiki.morpion;

import com.sadiki.morpion.grid.Displayer;
import com.sadiki.morpion.grid.Grid;
import com.sadiki.morpion.grid.GridFactory;
import com.sadiki.morpion.pair.Pair;
import com.sadiki.morpion.pair.PairFactory;
import com.sadiki.morpion.players.Players;
import com.sadiki.morpion.players.PlayersFactory;

public class Morpion {
    public static final String LINE_SEPARATOR = "\n";
    private final Players players;
    private final Grid grid;
    private final Displayer gridDisplayer;
    public Morpion(String dimension, String player1, String player2) {
        this.grid = new GridFactory().createFrom(dimension);
        this.players = new PlayersFactory().createFrom(player1, player2);
        this.gridDisplayer = new Displayer();
    }

    public void play(String playerName, String box) {
        Pair pair = new PairFactory().createPair(box);
        players.play(playerName, grid.getBox(pair));
    }

    public String report() {
        if (!grid.gameIsOver())
            return players.remainingGames(grid.remainingEmptyBoxes());
        else if(grid.gameIsWon())
            return players.winingPlayer(grid.winingSymbol());
        else return "Game Over, equality";
    }

    public String display() {
        return grid.display(gridDisplayer);
    }
}
