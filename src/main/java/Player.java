import java.util.Collections;
import java.util.List;

public abstract class Player {
	private CardsCollection playerDeck;
	private CardsCollection playerTable;
	private String playerName;
	private View view;
	private boolean playerTurn;
	private boolean draw;
	private boolean isWinner;


	public Player(String name, View view){
		this.playerDeck = new CardsCollection();
		this.playerTable = new CardsCollection();
		this.playerName = name;
		this.view = view;
		this.draw = false;
	}

	public void setAllCards(List<Garbage> cards) {
		playerDeck.addCardsFromListToDeck(cards);
	}


	public void moveCardIntoTopPlayerTable() {
		playerTable.addCardIntoTop(playerDeck.getAndRemoveTopCard());
	}


	public void addCardsIntoBottomPlayerDec(CardsCollection cardsCollection) {
		for (Garbage garbage : cardsCollection.getAllCards()) {
			playerDeck.addCardIntoBottom(garbage);
		}
	}


	public boolean isActive(){
		return playerDeck.getSize() != 0;
	}


	public boolean isPlayerTurn() {
		return playerTurn;
	}


	public boolean isDraw() {
		return draw;
	}

	public boolean isWinner(){
		return isWinner;
	}


	public void setPlayerTurn(boolean state) {
		this.playerTurn = state;
	}


	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public void setWinner(boolean winner) {
		this.isWinner = winner;
	}


	public Garbage getTopCartFromTable() {
		return playerTable.getTopCard();
	}


	public List<Garbage> getAllCardsFromTableAndRemove() {
		return playerTable.getAndRemoveAllCards();
	}



	public String getPlayerName() {
		return playerName;
	}


	public abstract Positions chooseStatisticToCompare();



	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}


	public CardsCollection getPlayerTable() {
		return playerTable;
	}


	//	public Garbage getAndRemoveTopCard(){
//		Garbage old = playerDeck.getTopCard();
//		playerDeck.removeTopCard();
//		return old;
//	}

}

