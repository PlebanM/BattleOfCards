import java.util.ArrayList;
import java.util.List;

public class Service {
	private GarbageDao garbageDao = new GarbageDao();
	private CardsCollection allCards = new CardsCollection();
	private List<Player> players;

	public Service(List<Player> players){
		this.players = players;
	}

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

	public void moveGarbageFromPlayerToTable(CardsCollection table, Player player) {
		table.addCardToBottom(player.getTopCard());

	}

	public void moveGarbageFromTableToPlayer(CardsCollection table, Player player) {
		for (Garbage card : table.getAllCards()){
			player.getPlayerDeck().addCardToBottom(card);
			table.removeCard(card);
		}
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

	public void dealCardsToPlayers(CardsCollection garbage, List<Player> players) {
		int numberOfPlayers = players.size();
		int numberOfCards = garbage.getSize();
		int i = 0;
		for (Player item : players) {
			item.addAllCard(garbage.subList(i, i + (numberOfCards / numberOfPlayers)));
			i += numberOfCards / numberOfPlayers;
		}
	}


	public void setGame(List<Player> players) { //todo czy kazdy user ma minimum 1 karte
		allCards.addCardsFromListToDeck(garbageDao.getAll());
		allCards.shuffleGarbage();
		this.dealCardsToPlayers(allCards, players);
	}
}
