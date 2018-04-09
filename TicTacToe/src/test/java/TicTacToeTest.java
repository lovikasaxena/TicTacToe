import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    Player player = new Player('X');
    Board board = new Board(3);

    @Test
    public void shouldReturnTrueForValidCoordinates() {
        Assert.assertTrue(board.validateCoordinates(new Coordinates(2, 3)));
    }

    @Test
    public void shouldReturnFalseForValidCoordinates() {
        Assert.assertFalse(board.validateCoordinates(new Coordinates(4, 3)));
    }

    @Test
    public void shouldReturnFalseForCoordinatesNotAlreadyTaken() {
        Coordinates coordinates = new Coordinates(2, 2);
        board.matrix.put(coordinates, player);
        Assert.assertFalse(board.coordinatesNotAlreadyMarked(coordinates));
    }

    @Test
    public void shouldReturnTrueForCoordinatesNotAlreadyTaken() {
        Coordinates coordinates = new Coordinates(2, 2);
        Assert.assertTrue(board.coordinatesNotAlreadyMarked(coordinates));
    }

    @Test
    public void shouldReturnTrueWhenCoordinatesMarked() throws WrongInputException {
        Coordinates coordinates = new Coordinates(2, 2);
        board.setCoordinatesMarked(coordinates, player);
        Assert.assertTrue(board.matrix.get(coordinates).playerName == (player.playerName));
    }

    @Test
    public void shouldReturnFalseWhenCoordinatesMarked() throws WrongInputException {
        Coordinates coordinates = new Coordinates(2, 2);
        Assert.assertFalse(board.matrix.get(coordinates).playerName == (player.playerName));
    }

    @Test
    public void shouldReturnTrueFor2Numbers() throws WrongInputException {
        Assert.assertTrue(player.validateInputHavingTwoNumbers(new String[]{"2", "3"}));
    }

    @Test(expected = WrongInputException.class)
    public void shouldReturnExceptionFor1Number() throws WrongInputException {
       player.validateInputHavingTwoNumbers(new String[]{"2"});
    }
}
