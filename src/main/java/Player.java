import java.util.List;

public abstract class Player {
	private CardsCollection playerDeck;
	private String playerName;
	private View view;


	public Player(String name, View view){
		playerDeck = new CardsCollection();
		this.playerName = name;
		this.view = view;
	}

	public Garbage getTopCard(){
		Garbage old = playerDeck.getTopCard();
		playerDeck.removeTopCard();
		return old;
	}

	public void setAllCards(List<Garbage> cards) {
		playerDeck.addCardsFromListToDeck(cards);
	}


	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}

	public abstract int chooseStatisticToCompare();

}
