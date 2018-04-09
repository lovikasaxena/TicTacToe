import java.util.ArrayList;

public class Diagonal extends Line {

    Diagonal() {
        listOfCoordinates = new ArrayList<>();
    }

    @Override
    Line getLine(int rowNumber, int size) {
        if (rowNumber == 1) {
            return getDiagonalTopLeft(size);
        }
        return getDiagonalBottomLeft(size);
    }

    private Line getDiagonalBottomLeft(int size) {
        for (int i = 1, j = size; i <= size; i++, j--) {
            Coordinates coordinates = new Coordinates(j, i);
            listOfCoordinates.add(coordinates);
        }
        return this;
    }

    private Line getDiagonalTopLeft(int size) {
        for (int i = 1; i <= size; i++) {
            Coordinates coordinates = new Coordinates(i, i);
            listOfCoordinates.add(coordinates);
        }
        return this;
    }
}
