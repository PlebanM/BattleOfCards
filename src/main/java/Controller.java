import java.util.List;

public class Controller {

	private List<Player> players;
	View mainView = new View();
	Service newGame = new Service();

	public void runGame() {
		String[] playerNames = {"Stef", "Mef"};
		for (String playerName : playerNames){
			players.add(new UserPlayer(playerName);
		}
	}

	public void handleCrud() {

	}
}
