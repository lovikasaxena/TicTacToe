import java.util.Scanner;

public class Player {
    char playerName;

    public Player(char playerName) {

        this.playerName = playerName;
    }

    Coordinates takeTurn() {
        String[] turnString = this.getInput().split(",");
        return new Coordinates(Integer.parseInt(turnString[0]), Integer.parseInt(turnString[1]));
    }

    String getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.playerName+">");
        String turnCoordinatesString = scanner.next();
        //System.out.println(turnCoordinatesString);
        return turnCoordinatesString;
    }

    public String win() {
        return playerName+ " WINS";

    }
}
