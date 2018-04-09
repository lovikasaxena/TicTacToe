import java.util.Objects;
import java.util.Scanner;

public class Player {
    char playerName;

    public Player(char playerName) {
        this.playerName = playerName;
    }

    Coordinates takeTurn() throws WrongInputException {
        String[] turnString = this.getInput().split(",");
        validateInputHavingTwoNumbers(turnString);
        return new Coordinates(Integer.parseInt(turnString[0]), Integer.parseInt(turnString[1]));
    }

     boolean validateInputHavingTwoNumbers(String[] turnString) throws WrongInputException {
        if (turnString.length != 2) {
            throw new WrongInputException("Wrong Input from user!");
        }
        return true;
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(this.playerName + ">");
        String turnCoordinatesString = scanner.next();
        return turnCoordinatesString;
    }

    public String win() {
        return playerName + " WINS";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerName == player.playerName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

}
