public class AIPlayer extends Player{

    public AIPlayer(){
        super();
        isAI = true;
    }

    @Override
    public int chooseStatisticToCompare() {
        Garbage topCard = getPlayerDeck().getTopCard();
        int statisticNumber = 1;
        int statisticToCompare = topCard.getSmell();
        if (topCard.getRecyclingTime() > statisticToCompare){
            statisticNumber = 2;
            statisticToCompare = topCard.getRecyclingTime();
        }
        if (topCard.getJunkValue() > statisticToCompare){
            statisticNumber = 3;
            statisticToCompare = topCard.getJunkValue();
        }
        if (topCard.getWeight() > statisticToCompare){
            statisticNumber = 4;
            statisticToCompare = topCard.getWeight();
        }
        return statisticNumber;
    }
}
