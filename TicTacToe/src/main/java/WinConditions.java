

import java.util.ArrayList;

public class WinConditions {
    private ArrayList<Line> lines;
    private Line line;

    public WinConditions() {
        this.lines = new ArrayList<>();
    }

    private ArrayList<Line> getWinningRows(int sizeOfBoard) {
        for (int i = 1; i <= sizeOfBoard; i++) {
            line = new Row();
            lines.add(line.getLine(i, sizeOfBoard));
        }
        return lines;
    }

    private ArrayList<Line> getWinningColumns(int sizeOfBoard) {
        for (int i = 1; i <= sizeOfBoard; i++) {
            line = new Column();
            lines.add(line.getLine(i, sizeOfBoard));
        }
        return lines;
    }

    private ArrayList<Line> getWinningDiagonals(int sizeOfBoard) {
        for (int i = 1; i <= 2; i++) { //Always only 2 diagonals
            line = new Diagonal();
            lines.add(line.getLine(i, sizeOfBoard));
        }
        return lines;
    }

     ArrayList<Line> getWinningLines(LineType lineType, int sizeOfBoard) {
        if (lineType.equals(LineType.HORIZONTAL))
            return getWinningRows(sizeOfBoard);
        if (lineType.equals(LineType.VERTICAL))
            return getWinningColumns(sizeOfBoard);
        if (lineType.equals(LineType.DIAGONAL))
            return getWinningDiagonals(sizeOfBoard);
        return lines;
    }

}
