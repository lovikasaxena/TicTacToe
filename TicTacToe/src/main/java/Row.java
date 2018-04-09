import java.util.ArrayList;

public class Row extends Line {

    Row() {
        listOfCoordinates = new ArrayList<>();
    }

    Line getLine(int rowNumber, int size) {
        for (int i = 1; i <= size; i++) {
            Coordinates coordinates = new Coordinates(i, rowNumber);
            listOfCoordinates.add(coordinates);
        }
        return this;
    }

}
