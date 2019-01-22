public abstract class Player {
	private CardsCollection playerDeck;
	private String playerName;
	boolean isAi;

	public Player(){
		playerDeck = new CardsCollection();
	}

	public CardsCollection getPlayerDeck() {
		return playerDeck;
	}

	public abstract int chooseStatisticToCompare();

}
