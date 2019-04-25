import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsCollection {

	private List<Garbage> allCards = new ArrayList<>();

	public void addCardsFromListToDeck(List<Garbage> items) {
		allCards.addAll(items);
	}


	public void shuffleCards() {
		Collections.shuffle(allCards);
	}


	public Garbage getAndRemoveTopCard() {
		Garbage buffer = allCards.get(allCards.size() - 1);
		allCards.remove(allCards.size() - 1);
		return buffer;
	}


	public Garbage getTopCard() {
		return allCards.get(allCards.size() - 1);
	}


	public void addCardIntoTop(Garbage item){
		allCards.add(item);
	}


	public void addCardIntoBottom(Garbage item){
		allCards.add(0, item);
	}


	public List<Garbage> getAndRemoveAllCards(){
		List<Garbage> buffer = new ArrayList<>(allCards);
		allCards.clear();
		return buffer;
	}


	public int getSize() {
		return allCards.size();
	}


	public List<Garbage> getAllCards() {
		return allCards;
	}


//	public void removeAllCards() {
//		allCards.clear();
//	}


	//	public Garbage getCartByID(int id) {
//		return allCards.get(id);
//	}


	//	public void removeTopCard(){
//		allCards.remove(allCards.size() - 1);
//	}

}
