public class Game {
    public static void main(String[] args) {
        String output = new TicTacToe(new Player('X'), new Player('O'), new Board()).play();
        System.out.println(output);
    }
}
