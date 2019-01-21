import java.util.Arrays;
import java.util.List;

public class Controller {
	public void setGame() {
		GarbageDao garbageDao = new GarbageDao();
		Service service = new Service();
		List<Garbage> allCards = garbageDao.getAll();
		service.shuffleGarbage(allCards);
		Player player1 = new Player();
		Player player2 = new Player();
		service.setCardsToPlayers(allCards, Arrays.asList(player1, player2));
		player1.getAllCards().forEach(System.out::println);
		System.out.println("------");
		player2.getAllCards().forEach(System.out::println);
	}

	public void runGame() {

	}

	public void handleCrud() {

	}
}
