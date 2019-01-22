public class UserPlayer extends Player {

    PlayerView playerView;

    public UserPlayer(){
        super();
        isAi = false;
        playerView = new PlayerView;
    }

    @Override
    public int chooseStatisticToCompare() {
        playerView.getPositionOnCard();
    }
}
