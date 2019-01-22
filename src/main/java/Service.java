import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
	private GarbageDao garbageDao;
//	private Service service;
	private CardsCollection allCards;
	private List<Player> players;

	public int compareTwoGarbage(Garbage item1, Garbage item2, Positions choice) {

		if (choice == Positions.SMELL) {
			if(item1.getSmell() > item2.getSmell()){
				return 1;
			} else if (item1.getSmell() < item2.getSmell()) {
				return -1;
			} else {
				return 0;
			}
		} else if (choice == Positions.JUNKVALUE) {
			if(item1.getJunkValue() > item2.getJunkValue()){
				return 1;
			} else if (item1.getJunkValue() < item2.getJunkValue()) {
				return -1;
			} else {
				return 0;
			}
		} else if (choice == Positions.RECYCLINGTIME) {
			if(item1.getRecyclingTime() > item2.getRecyclingTime()){
				return 1;
			} else if (item1.getRecyclingTime() < item2.getRecyclingTime()) {
				return -1;
			} else {
				return 0;
			}
		} else if (choice == Positions.WEIGHT) {
			if(item1.getWeight() > item2.getWeight()){
				return 1;
			} else if (item1.getWeight() < item2.getWeight()) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;
	}

	public void moveGarbageFromPlayerTable(CardsCollection table, Player player) {
		table.addCard(player.getTopCard());
//		player.removeTopCard();
	}

	public void moveGarbageFromTableToPlayer(CardsCollection table, Player player) {
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


	public boolean setGame(String... names) { //todo czy kazdy user ma minimum 1 karte
		garbageDao = new GarbageDao();
//		service = new Service();
		allCards = new CardsCollection();
		players = new ArrayList<>();
		allCards.loadAllCards(garbageDao.getAll());
		allCards.shuffleGarbage();
		for (String item : names) {
			players.add(new Player(item));
		}
		this.setCardsToPlayers(allCards, players);


		for (Player item : players) {
			item.getAllCards().getAllCards().forEach(System.out::println);
			System.out.println("------");
		}

		return true;
	}
}
