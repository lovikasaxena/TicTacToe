import java.util.ArrayList;

public class Column extends Line {

    Column() {
        listOfCoordinates = new ArrayList<>();
    }

    Line getLine(int columnNumber, int size) {
        for (int i = 1; i <= size; i++) {
            Coordinates coordinates = new Coordinates(columnNumber, i);
            listOfCoordinates.add(coordinates);
        }
        return this;
    }
}
