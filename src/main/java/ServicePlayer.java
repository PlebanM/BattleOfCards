import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServicePlayer {
	private List<Player> players = new ArrayList<>();
	private View view;

	public ServicePlayer(View view) {
		this.view = view;
	}

	public boolean setPlayers() {
		int userPlayersIndex = 0;
		int AiUserPlayersIndex = 1;
		view.showAddPlayersMenu();
		List<List<String>> allPlayers =  view.getPlayers();
		if (allPlayers.get(userPlayersIndex).size() != 0) {
			for (String name : allPlayers.get(userPlayersIndex)) {
				players.add(new UserPlayer(name, view));
			}
		}
		if (allPlayers.get(AiUserPlayersIndex).size() != 0) {
			for (String name : allPlayers.get(AiUserPlayersIndex)) {
				players.add(new AIPlayer(name, view));
			}
		}
//		Random random = new Random(); //todo comment only for tests
//		players.get(random.nextInt(players.size())).setPlayerTurn();
		players.get(1).setPlayerTurn(true);
		return players.size() != 0;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public boolean isWinner() {
		int numberOfActivePlayers = 0;
		for (Player player : players) {
			if(player.isActive()){
				numberOfActivePlayers++;
			}
		}
		return numberOfActivePlayers == 1;
	}
}
