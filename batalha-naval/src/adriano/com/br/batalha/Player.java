package adriano.com.br.batalha;

public class Player extends Validation {

    private String name;
    private Board board = new Board();
    private boolean typePlayer;
    private int ships = 10;

    public Player(boolean typePlayer, String name) {
        this.typePlayer = typePlayer;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getShips() {
        return ships;
    }

    public void setShips(int ships) {
        this.ships = ships;
    }

    public char getPlayerBoardCoordenate(int[] coordinate) {
        return this.board.getCoordinate(coordinate);
    }
}
