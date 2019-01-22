import java.util.ArrayList;
import java.util.List;

public class CardsCollection {
	private List<Garbage> allCards = new ArrayList<Garbage>();

	public List<Garbage> getAllCards(){
		return allCards;
	}

	public Garbage getTopCard() {
		return allCards.get(0);
	}

	public void removeTopCard(){
		allCards.remove(0);
	}

	public void addCardsToBottom(List<Garbage> cardsToAdd){
		for (Garbage card : cardsToAdd){
			allCards.add(card);
		}
	}

}
