import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsCollection {
	private List<Garbage> allCards = new ArrayList<>();

	public void loadAllCards(List<Garbage> items) {
		allCards.addAll(items);
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

	public void removeTopCard(){
		allCards.remove(0);
	}

	public void addCardsToBottom(Garbage item){
		allCards.add(item);
	}

	public int getSize() {
		return allCards.size();
	}

	public List<Garbage> subList(int start, int end) {
		return allCards.subList(start, end);
	}

}
