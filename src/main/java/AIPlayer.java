public class AIPlayer extends Player{

    public AIPlayer(){
        super();
        isAI = true;
    }

    @Override
    public int chooseStatisticToCompare() {
        return 0;
    }
}
