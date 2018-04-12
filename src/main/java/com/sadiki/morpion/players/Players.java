package com.sadiki.morpion.players;

import com.sadiki.morpion.grid.box.Box;

public class Players {
    private final Player player1;
    private final Player player2;

    Players(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(String playerName, Box box) {
        getPlayer(playerName).play(box);
    }

    private Player getPlayer(String playerName) {
        if (player1.getName().equals(playerName))
            return player1;
        else if (player2.getName().equals(playerName))
            return player2;
        return null;
    }

    public String remainingGames(int remainingEmptyBoxes) {
        return player1remainingGames(remainingEmptyBoxes) + " games for player1, " + player2remainingGames(remainingEmptyBoxes) + " games for player2";
    }

    private int player1remainingGames(int remainingEmptyBoxes) {
        return (remainingEmptyBoxes / 2 + remainingEmptyBoxes % 2);
    }

    private int player2remainingGames(int remainingEmptyBoxes) {
        return (remainingEmptyBoxes / 2);
    }

    public String winingPlayer(String winingSymbol) {
        String winingPlayerName;
        if (player1.hasSameSymbol(winingSymbol))
            winingPlayerName = player1.getName();
        else winingPlayerName = player2.getName();
        return "Game Over, " + winingPlayerName + " is a winner";
    }
}
