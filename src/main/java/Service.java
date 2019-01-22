import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

	public int compareTwoGarbage(Garbage item1, Garbage item2, Positions choice) {
		if (choice == Positions.SMELL) {
			if(item1.getSmell() > item2.getSmell()){
				return 1;
			} else if (item1.getSmell() < item2.getSmell()) {
				return -1;
			} else {
				return 1;
			}
		} else if (choice == Positions.JUNKVALUE) {
			if(item1.getJunkValue() > item2.getJunkValue()){
				return 1;
			} else if (item1.getJunkValue() < item2.getJunkValue()) {
				return -1;
			} else {
				return 1;
			}
		} else if (choice == Positions.RECYCLINGTIME) {
			if(item1.getRecyclingTime() > item2.getRecyclingTime()){
				return 1;
			} else if (item1.getRecyclingTime() < item2.getRecyclingTime()) {
				return -1;
			} else {
				return 1;
			}
		} else if (choice == Positions.WEIGHT) {
			if(item1.getWeight() > item2.getWeight()){
				return 1;
			} else if (item1.getWeight() < item2.getWeight()) {
				return -1;
			} else {
				return 1;
			}
		}
		return 666;
	}

	public void moveGarbageFromPlayerTable(Table table, Player player) {
		table.addCard(player.getTopCard());
		player.removeTopCard();
	}

	public void moveGarbageFromTableToPlayer(Table table, Player player) {
		player.addAllCard(table.getAllCards());
		table.removeCards();
	}



	public void addAllGarbageToPlayer(Player player, List<Garbage> garbage) {
		player.addAllCard(garbage);
	}

	public boolean saveGarbage(Player player) {
		return false;
	}

	public ArrayList<Garbage> loadGarbageFromDB() {
		return new ArrayList<Garbage>();
	}

	public boolean updateGarbage(Garbage garbage, int index) {
		return false;
	}

	public void setCardsToPlayers(CardsCollection garbage, List<Player> players) {
		int numberOfPlayers = players.size();
		int numberOfCards = garbage.getSize();
		int i = 0;
		for (Player item : players) {
			item.addAllCard(garbage.subList(i, i + (numberOfCards / numberOfPlayers)));
			i += numberOfCards / numberOfPlayers;
		}
	}


	public void setGame(String... names) {
		GarbageDao garbageDao = new GarbageDao();
		Service service = new Service();
		CardsCollection allCards = new CardsCollection();
		allCards.loadAllCards(garbageDao.getAll());
		allCards.shuffleGarbage();
		List<Player> players = new ArrayList<>();
		for (String item : names) {
			players.add(new Player(item));
		}
		service.setCardsToPlayers(allCards, players);
		for (Player item : players) {
			item.getAllCards().getAllCards().forEach(System.out::println);
			System.out.println("------");
		}
	}
}
