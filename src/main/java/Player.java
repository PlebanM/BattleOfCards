import java.util.List;

public abstract class Player {
	private CardsCollection playerDeck;
	private String playerName;
	private View view;
	private boolean playerTurn;


	public Player(String name, View view){
		this.playerDeck = new CardsCollection();
		this.playerName = name;
		this.view = view;
	}


	public Garbage getAndRemoveTopCard(){
		Garbage old = playerDeck.getTopCard();
		playerDeck.removeTopCard();
		return old;
	}


	public void setAllCards(List<Garbage> cards) {
		playerDeck.addCardsFromListToDeck(cards);
	}


	public boolean isActive(){
		return playerDeck.getSize() != 0;
	}


	public boolean isPlayerTurn() {
		return playerTurn;
	}


	public void setPlayerTurn(boolean state) {
		this.playerTurn = state;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void addCardsToBottom(CardsCollection cardsCollection) {
		for (Garbage garbage : cardsCollection.getAllCards()) {
			playerDeck.addCardToBottom(garbage);
		}
	}


	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}


	public void showLooseMessage() {
		view.showLooseMessage(this.playerName);
	}


	public abstract Positions chooseStatisticToCompare();
}

