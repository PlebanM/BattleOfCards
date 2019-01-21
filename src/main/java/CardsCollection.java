import java.util.List;

public class CardsCollection {
	private List<Garbage> allCards;

	public Garbage getTopCard() {
		return new Garbage("adf", 1, 2, 3, 4);
	}

	public boolean addCardsToBottom(List<Garbage> garbage){
		return false;
	}

}
