import java.util.List;

public abstract class Player {
	private CardsCollection playerDeck;
	private String playerName;
	boolean isAi;

	public Player(String name){
		playerDeck = new CardsCollection();
		this.playerName = name;
	}

	public Garbage getTopCard(){
		Garbage old = playerDeck.getTopCard();
		playerDeck.removeTopCard();
		return old;
	}

//	public void removeTopCard(){
//		playerDeck.removeTopCard();
//	}

//	public void addAllCard(CardsCollection cards) {
//		playerDeck.loadAllCards(cards);
//
//	}

//	public int getPlayerScore(){
//		return playerDeck.size();
//	}

	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}

	public abstract int chooseStatisticToCompare();

}
