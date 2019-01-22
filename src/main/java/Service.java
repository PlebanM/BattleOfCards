import java.util.ArrayList;
import java.util.List;

public class Service {
	private GarbageDao garbageDao;
//	private Service service;
	private CardsCollection allCards;
	private List<Player> players;

	public List<Integer> compareTwoGarbage(Positions choice, List<Garbage> items) {
		int max = 0;
		List<Integer> winNumbers = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getByChoice(choice) > max) {
				max = items.get(i).getSmell();
			}
		}
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getByChoice(choice) == max) {
				winNumbers.add(i + 1);
			}
		}

		return winNumbers;
	}

//	public void moveGarbageFromPlayerTable(CardsCollection table, Player player) {
//		table.addCard(player.getTopCard());
////		player.removeTopCard();
//	}
//
//	public void moveGarbageFromTableToPlayer(CardsCollection table, Player player) {
//		player.addAllCard(table.getAllCards());
//		table.removeCards();
//	}
//
//
//
//	public void addAllGarbageToPlayer(Player player, List<Garbage> garbage) {
//		player.addAllCard(garbage);
//	}

	public boolean saveGarbage(Player player) {
		return false;
	}

	public ArrayList<Garbage> loadGarbageFromDB() {
		return new ArrayList<Garbage>();
	}

	public boolean updateGarbage(Garbage garbage, int index) {
		return false;
	}

//	public void setCardsToPlayers(CardsCollection garbage, List<Player> players) {
//		int numberOfPlayers = players.size();
//		int numberOfCards = garbage.getSize();
//		int i = 0;
//		for (Player item : players) {
//			item.addAllCard(garbage.subList(i, i + (numberOfCards / numberOfPlayers)));
//			i += numberOfCards / numberOfPlayers;
//		}
//	}


//	public boolean setGame(String... names) { //todo czy kazdy user ma minimum 1 karte
//		garbageDao = new GarbageDao();
////		service = new Service();
//		allCards = new CardsCollection();
//		players = new ArrayList<>();
//		allCards.loadAllCards(garbageDao.getAll());
//		allCards.shuffleGarbage();
//		for (String item : names) {
//			players.add(new Player(item));
//		}
//		this.setCardsToPlayers(allCards, players);
//
//
//		for (Player item : players) {
//			item.getAllCards().getAllCards().forEach(System.out::println);
//			System.out.println("------");
//		}
//
//		return true;
//	}
}
