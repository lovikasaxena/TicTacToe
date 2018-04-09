/***
 * Understands a board where 2 players can play the game of Tic Tac Toe.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
     HashMap<Coordinates, Player> matrix;
    private int sizeOfBoard;
    private WinConditions winConditions;

    public Board(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
        matrix = new HashMap<>();
        initializeBoardCellsUsingMap(sizeOfBoard);
    }

    private void initializeBoardCellsUsingMap(int sizeOfBoard) {
        Player temporaryPlayer = new Player('.');
        for (int i = 1; i <= sizeOfBoard; i++) {
            for (int j = 1; j <= sizeOfBoard; j++) {
                matrix.put(new Coordinates(i, j), temporaryPlayer);
            }
        }
    }

    void setCoordinatesMarked(Coordinates turnCoordinates, Player player) throws WrongInputException {
        if (!validateCoordinates(turnCoordinates)) {
            throw new WrongInputException("Wrong Input from user!");
        }
        matrix.put(turnCoordinates, player);
    }

     boolean validateCoordinates(Coordinates turnCoordinates) {
        if (turnCoordinates.x > sizeOfBoard || turnCoordinates.y > sizeOfBoard) {
            return false;
        }
        return this.coordinatesNotAlreadyMarked(turnCoordinates);
    }

     boolean coordinatesNotAlreadyMarked(Coordinates turnCoordinates) {
        return matrix.get(turnCoordinates).playerName == '.' ? true : false;
    }

    boolean hasPlayerWon(Player player) {
        if (checkForWin(player, LineType.HORIZONTAL)) return true;
        if (checkForWin(player, LineType.VERTICAL)) return true;
        if (checkForWin(player, LineType.DIAGONAL)) return true;
        return false;
    }

    private boolean checkForWin(Player player, LineType lineType) {
        winConditions = new WinConditions();
        ArrayList<Line> lines = winConditions.getWinningLines(lineType, sizeOfBoard);
        for (Line line : lines) {
            ArrayList<Coordinates> listOfCoordinates = line.listOfCoordinates;
            if (fullLineMarkedBySamePlayer(player, listOfCoordinates)) return true;
        }
        return false;
    }

    private boolean fullLineMarkedBySamePlayer(Player player, ArrayList<Coordinates> listOfCoordinates) {
        int count = 0;
        for (Coordinates coordinates : listOfCoordinates) {
            if (matrix.get(coordinates).playerName == player.playerName) {
                count++;
            }
        }
        if (count == sizeOfBoard) {
            return true;
        }
        return false;
    }

    void displayBoard() {
        for (int i = 1; i <= sizeOfBoard; i++) {
            for (int j = 1; j <= sizeOfBoard; j++) {
                System.out.print(matrix.get(new Coordinates(j, i)).playerName + "\t");
            }
            System.out.println("\n");
        }
    }
}

