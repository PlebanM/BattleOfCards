import java.util.ArrayList;

import java.util.List;

public class Controller {

	private List<Player> players;
	private View mainView = new View();
	private Service newGame;

	public void runGame() {



		String[] playerNames = {"Stef", "Mef"};
		for (String playerName : playerNames){
			players.add(new UserPlayer(playerName);
		}

		Service test = new Service();
		GarbageDao testDAO = new GarbageDao();
		List<Garbage> garbage = new ArrayList<>(testDAO.getAll());
		List<Integer> win = test.compareTwoGarbage( Positions.SMELL, garbage);
		System.out.println(win);

	}

	public void handleCrud() {

	}
}
