package adriano.com.br.batalha;

public class Main {
    public static void main(String[] args) {

        Battleship naval = new Battleship();
        naval.setPlayer(new Player(true, "Adriano"));
        System.out.println(naval.getPlayer().getName());
        naval.getPlayer().getBoard().printBoard();
        naval.getPlayer().
    }
}
