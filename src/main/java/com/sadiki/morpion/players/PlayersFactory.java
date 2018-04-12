package com.sadiki.morpion.players;

public class PlayersFactory {
    private static final String SEPARATOR = ":";
    public Players createFrom(String player1Info, String player2Info) {
        Player player1 = createPlayer(player1Info);
        Player player2 = createPlayer(player2Info);
        return new Players(player1,player2);
    }

    private Player createPlayer(String player1Info) {
        String playerName = player1Info.split(SEPARATOR)[0];
        String playerSymbol = player1Info.split(SEPARATOR)[1];
        return new Player(playerName,playerSymbol);
    }
}
