import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private CardsCollection playerDeck = new CardsCollection();
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public Garbage getTopCard(){
		return null;
	}

	public void removeTopCard(){
	}

	public void addAllCard(List<Garbage> cards) {
		playerDeck.loadAllCards(cards);

	}

//	public int getPlayerScore(){
//		return playerDeck.size();
//	}

	public CardsCollection getAllCards() {
		return playerDeck;
	}

}
