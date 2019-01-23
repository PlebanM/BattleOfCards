public class UserPlayer extends Player {


    public UserPlayer(String name, View view){
        super(name, view);
    }

    @Override
    public Positions chooseStatisticToCompare() {
        //todo make code , show him top card
        return Positions.RECYCLINGTIME;
    }
}
