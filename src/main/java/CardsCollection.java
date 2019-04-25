import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsCollection {
	private List<Garbage> allCards = new ArrayList<>();

	public void addCardsFromListToDeck(List<Garbage> items) {
		allCards.addAll(items);
//		for (Garbage card : items){
//			this.addCardToBottom(card);
//		}
	}


	public void shuffleGarbage() {
		Collections.shuffle(allCards);
	}


	public List<Garbage> getAllCards(){
		return allCards;
	}


	public Garbage getTopCard() {
		return allCards.get(allCards.size() - 1);
	}


	public void removeTopCard(){
		allCards.remove(allCards.size() - 1);
	}


	public void addCardToBottom(Garbage item){
		allCards.add(0, item);
	}


	public int getSize() {
		return allCards.size();
	}


	public Garbage getCartByID(int id) {
		return allCards.get(id);
	}


	public void removeAllCards() {
		allCards.clear();
	}
}
