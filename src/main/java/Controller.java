import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
//	public void setGame(String... names) {
//		GarbageDao garbageDao = new GarbageDao();
//		Service service = new Service();
//		CardsCollection allCards = new CardsCollection();
//		allCards.loadAllCards(garbageDao.getAll());
//		allCards.shuffleGarbage();
//		List<Player> players = new ArrayList<>();
//		for (String item : names) {
//			players.add(new Player(item));
//		}
//		service.setCardsToPlayers(allCards, players);
//		for (Player item : players) {
//			item.getAllCards().getAllCards().forEach(System.out::println);
//			System.out.println("------");
//		}
//	}

	public void runGame() {
		Service newGame = new Service();
		newGame.setGame("Stef", "Mef");
	}

	public void handleCrud() {

	}
}
