public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player presentPlayer;
    private Board board;
    private int numberOfChancesPlayed;

    public TicTacToe(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        presentPlayer = player1;
        this.board = board;
        numberOfChancesPlayed = 0;
    }

    public String play() throws WrongInputException{
        do {
            board.displayBoard();
            board.setCoordinatesMarked(presentPlayer.takeTurn(), presentPlayer);
            numberOfChancesPlayed++;
            if (numberOfChancesPlayed > 4 && board.hasPlayerWon(presentPlayer)) {
                board.displayBoard();
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