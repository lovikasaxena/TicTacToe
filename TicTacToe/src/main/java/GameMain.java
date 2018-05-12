public class GameMain {
    public static void main(String[] args) {
        try {
            String output = new TicTacToe(new Player('X'), new Player('O'), new Board(3)).play();
            System.out.println(output);
        }
        catch (WrongInputException e){
            e.printStackTrace();
        }
    }
}
