public class UserPlayer extends Player {

    private PlayerView playerView;

    public UserPlayer(String name){
        super(name);
        isAi = false;
        playerView = new PlayerView;
    }

    @Override
    public int chooseStatisticToCompare() {
        playerView.getPositionOnCard();
    }
}
