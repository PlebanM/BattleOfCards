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

	public void addAllCard(CardsCollection cards) {
		playerDeck.addCardsFromListToDeck(cards);

	}

	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}

	public abstract int chooseStatisticToCompare();

}
