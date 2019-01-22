import java.util.ArrayList;
import java.util.List;

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
		return players.size() != 0;
	}


	public List<Player> getPlayers() {
		return players;
	}



}
