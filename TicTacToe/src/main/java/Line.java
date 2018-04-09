import java.util.ArrayList;

public abstract class Line {
    ArrayList<Coordinates> listOfCoordinates;

    abstract Line getLine(int rowNumber, int size);

}
