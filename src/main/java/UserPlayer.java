public class UserPlayer extends Player {


    public UserPlayer(String name, View view){
        super(name, view);
    }

    @Override
    public int chooseStatisticToCompare() {
        return 0;
    }

//    @Override
//    public int chooseStatisticToCompare(View view) {
//        view.getPositionOnCard();
//    }
}
