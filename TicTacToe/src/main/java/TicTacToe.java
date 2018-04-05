public class TicTacToe {
    Player player1;
    Player player2;
    Player presentPlayer;
    Board board;
    int numberOfChancesPlayed;

    public TicTacToe(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        presentPlayer = player1;
        this.board = board;
        numberOfChancesPlayed = 0;
    }

    public String play() {
        do {
            this.board.displayBoard();
            Coordinates turnCoordinates = presentPlayer.takeTurn();
            if (this.board.isCoordinateTaken(turnCoordinates)) {
                continue;
            }
            this.board.setCoordinatesMarked(turnCoordinates, presentPlayer);
            numberOfChancesPlayed++;
            if (numberOfChancesPlayed > 4 && board.hasPlayerWon(presentPlayer)) {
                this.board.displayBoard();
                return presentPlayer.win();
            }
            presentPlayer = changePlayer(presentPlayer);
        } while (numberOfChancesPlayed < 9);
        return "GAME DRAW";
    }

    private Player changePlayer(Player presentPlayer) {
        if (presentPlayer.equals(player1)) {
            return player2;
        }
        return player1;
    }
}