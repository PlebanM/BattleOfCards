import java.util.ArrayList;
import java.util.List;

public class ServiceGame {
	private GarbageDao garbageDao = new GarbageDao();
	private CardsCollection allCards = new CardsCollection();
	private CardsCollection table = new CardsCollection();
	private View view;


	public ServiceGame(View view){
		this.view = view;
	}


	public void nextTour(List<Player> players) {
		handleLooser(players);
		Positions choice = this.getChoice(players);
		for (Player player : players) {
			if (player.isActive()) {
				table.addCardToBottom(player.getAndRemoveTopCard());
			}
		}
		List<Integer> winners = this.compareGarbage(choice, table, players);
		if (winners.size() == 1) {
			players.get(winners.get(0)).addCardsToBottom(table);
			players.get(winners.get(0)).setPlayerTurn(true);
			table.removeAllCards();
		}
	}


	private Positions getChoice(List<Player> players) {
		for (Player player : players) {
			if (player.isActive() && player.isPlayerTurn()) {
				player.setPlayerTurn(false);
				return player.chooseStatisticToCompare();
			}
		}
		return Positions.ERROR;
	}


	private List<Integer> compareGarbage(Positions choice, CardsCollection table, List<Player> players) {
		int max = 0;
		List<Integer> winNumbers = new ArrayList<>();
		int numberActivePlayers = 0;
		for (Player player : players) {
			numberActivePlayers += (player.isActive() ? 1 : 0);
		}
		for (int i = 0; i < numberActivePlayers; i++) {
			if (table.getCartByID(i).getByChoice(choice) > max) {
				max = table.getCartByID(i).getByChoice(choice);
			}
		}
		for (int i = 0; i < numberActivePlayers; i++) {
			if (table.getCartByID(i).getByChoice(choice) == max) {
				winNumbers.add(i);
			}
		}
		return winNumbers;
	}


	private void handleLooser(List<Player> players) {
		List<Integer> idToRemove = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).isActive()) {
				players.get(i).showLooseMessage();
				idToRemove.add(i);
			}
		}
//		System.out.println(idToRemove + " <--- idToRemove");
//		System.out.println(players + " <--- players");
		for (int i = idToRemove.size() - 1; i >= 0; i--) {
			players.remove(i);
		}
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



	public boolean saveGarbage(Player player) {
		return false;
	}



	public boolean updateGarbage(Garbage garbage, int index) {
		return false;
	}
}
