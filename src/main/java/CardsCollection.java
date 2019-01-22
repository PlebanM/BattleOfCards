import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsCollection {
	private List<Garbage> allCards = new ArrayList<>();

	public void addCardsFromListToDeck(List<Garbage> items) {
		for (Garbage card : items){
			this.addCardToBottom(card);
		}
	}

	public void shuffleGarbage() {
		Collections.shuffle(allCards);
	}

	public List<Garbage> getAllCards(){
		return allCards;
	}

	public Garbage getTopCard() {
		return allCards.get(0);
	}

	public void removeCard(Garbage card){
		allCards.remove(card);
	}

	public void removeTopCard(){
		allCards.remove(0);
	}

	public void addCardToBottom(Garbage item){
		allCards.add(item);
	}

	public int getSize() {
		return allCards.size();
	}
}
