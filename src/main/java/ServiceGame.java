import java.util.ArrayList;
import java.util.List;

public class ServiceGame {
	private GarbageDao garbageDao = new GarbageDao();
	private CardsCollection allCards = new CardsCollection();
	private View view;

	public ServiceGame(View view){
		this.view = view;
	}

	public boolean loadGarbageFromDB() {
		allCards.addCardsFromListToDeck(garbageDao.getAll());
		return allCards.getSize() != 0;
	}

	public boolean dealCardsToPlayers(List<Player> players) {
		int numberOfCards = allCards.getSize();
		int numberOfPlayers = players.size();
		if (numberOfPlayers >= numberOfCards){
			return false;
		}
		allCards.shuffleGarbage();

		int i = 0;
		for (Player player : players) {
			player.setAllCards(allCards.getAllCards().subList(i, i + (numberOfCards / numberOfPlayers)));
			i += numberOfCards / numberOfPlayers;
		}
		return true;
	}










	public List<Integer> compareGarbage(Positions choice, List<Garbage> items) {
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



	public boolean updateGarbage(Garbage garbage, int index) {
		return false;
	}







}
