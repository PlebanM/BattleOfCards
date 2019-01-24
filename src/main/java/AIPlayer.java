public class AIPlayer extends Player{

	public AIPlayer(String name, View view){
		super(name, view);
	}

	@Override
	public Positions chooseStatisticToCompare() {
		// todo only choice to compare
		Garbage topCard = getPlayerDeck().getTopCard();
		Positions choice = Positions.SMELL;
		int statisticToCompare = topCard.getSmell();
		if (topCard.getRecyclingTime() > statisticToCompare){
			choice = Positions.RECYCLINGTIME;
			statisticToCompare = topCard.getRecyclingTime();
		}
		if (topCard.getJunkValue() > statisticToCompare){
			choice = Positions.JUNKVALUE;
			statisticToCompare = topCard.getJunkValue();
		}
		if (topCard.getWeight() > statisticToCompare){
			choice = Positions.WEIGHT;
		}
        System.out.println(choice + " <------------------------");
		return choice;
	}
}
