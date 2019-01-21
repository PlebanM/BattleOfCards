import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private List<Garbage> playerDeck = new ArrayList<>();


	public Garbage getTopCard(){
		return null;
	}

	public void removeTopCard(){
	}

	public void addAllCard(List<Garbage> cards) {
		playerDeck.addAll(cards);

	}

	public int getPlayerScore(){
		return playerDeck.size();
	}

	public List<Garbage> getAllCards() {
		return playerDeck;
	}

}
