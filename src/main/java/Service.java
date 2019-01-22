import java.util.ArrayList;
import java.util.List;

public class Service {
	private GarbageDao garbageDao = new GarbageDao();
	private CardsCollection allCards = new CardsCollection();
	private List<Player> players;


	public Service(List<Player> players){
		this.players = players;
	}


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
