import java.util.ArrayList;
import java.util.List;
public class Z37 {
    private List<Integer> players;
    private List<Integer> eliminatedPlayers;
    private int currentPlayerIndex;
    private int winner;
    public Z37(int totalPlayers, int startingPlayer) {
        players = new ArrayList<>();
        for (int i = 1; i <= totalPlayers; i++) {
            players.add(i);
        }
        eliminatedPlayers = new ArrayList<>();
        currentPlayerIndex = startingPlayer - 1;
        winner = 0;
    }
    public List<Integer> playGame() {
        while (players.size() > 1) {
            currentPlayerIndex = (currentPlayerIndex + 2) % players.size();
            int eliminatedPlayer = players.remove(currentPlayerIndex);
            eliminatedPlayers.add(eliminatedPlayer);
        }
        winner = players.get(0);
        return eliminatedPlayers;
    }
    public int getWinner() {
        return winner;
    }
}
