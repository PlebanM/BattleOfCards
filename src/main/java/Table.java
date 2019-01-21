import java.util.ArrayList;
import java.util.List;

public class Table {
	private List<Garbage> playerDeck = new ArrayList<>();

	public void addCard(Garbage item){
		playerDeck.add(item);
	}

	public List<Garbage> getAllCards(){
		return playerDeck;
	}

	public void removeCards() {
		playerDeck.clear();
	}

}
