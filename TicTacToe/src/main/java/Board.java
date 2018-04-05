import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Player> matrix;

    public Board() {
        matrix = new HashMap<>();
        Player temporaryPlayer = new Player('.');
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                matrix.put(new Coordinates(i, j), temporaryPlayer);
            }
        }
    }

    public void setCoordinatesMarked(Coordinates turnCoordinates, Player player) {
        matrix.put(turnCoordinates, player);
    }

    public boolean isCoordinateTaken(Coordinates turnCoordinates) {
        return matrix.get(turnCoordinates).playerName == '.' ? false : true;
    }

    Boolean hasPlayerWon(Player player) {
        if (checkHorizontalAndVerticalLineWin(player)) return true;
        if (checkCrossLinesWin(player)) return true;
        return false;
    }

    private boolean checkCrossLinesWin(Player player) {
        int countCrossLine1 = 0;
        for (int i = 1; i <= 3; i++) {
            if (matrix.get(new Coordinates(i, i)).playerName == (player.playerName)) {
                countCrossLine1++;
            }
        }
        if (countCrossLine1 == 3 ||
                (matrix.get(new Coordinates(1,3)).playerName == (player.playerName) &&
                matrix.get(new Coordinates(2,2)).playerName == (player.playerName) &&
                matrix.get(new Coordinates(3,1)).playerName == (player.playerName))) {
            return true;
        }
        return false;
    }

    private boolean checkHorizontalAndVerticalLineWin(Player player) {
        int countHorizontalLine = 0, countVerticalLine = 0;
        for (int i = 1; i <= 3; i++) {
            countHorizontalLine = countVerticalLine = 0;
            for (int j = 1; j <= 3; j++) {
                if (matrix.get(new Coordinates(i, j)).playerName == (player.playerName)) {
                    countHorizontalLine++;
                }
                if (matrix.get(new Coordinates(j, i)).playerName == (player.playerName)) {
                    countVerticalLine++;
                }
            }
            if (countHorizontalLine == 3 || countVerticalLine == 3) {
                return true;
            }
        }
        return false;
    }

    void displayBoard() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(matrix.get(new Coordinates(i, j)).playerName + "\t");
            }
            System.out.println("\n");
        }
    }

}
