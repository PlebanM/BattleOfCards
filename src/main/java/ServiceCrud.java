import java.util.ArrayList;
import java.util.List;

public class ServiceCrud {

    private View view;
    private GarbageDao garbageDao;

    public ServiceCrud(View view, GarbageDao garbageDao) {
        this.view = view;
        this.garbageDao = garbageDao;
    }

    public void handleGeneralCrud(int crudMenuOption) {
        switch (crudMenuOption) {
            case 1:
                createNewCard();
                break;
            case 2:
                deleteChosenCard(chooseCardFromEntireDeck());
                break;
            case 3:
                editChosenCard(chooseCardFromEntireDeck());
                break;
            case 0:
                System.out.println(" ");;
                break;
        }
    }

    public void createNewCard() {
        // wysylac pojedynczo stringi do view, wracaja inty
        String newName = "Junk!"; //to bedzie z View po przekazaniu Stringa name
        int smell = 0; //to bedzie z View po przekazaniu Stringa smell
        int recyclingTime = 1; //to bedzie z View po przekazaniu Stringa recycling
        int junkValue = 2; //to bedzie z View po przekazaniu Stringa junkvalue
        int weight = 3; //to bedzie z View po przekazaniu Stringa weight
        Garbage newCard = new Garbage(newName, smell, recyclingTime, junkValue, weight);
        garbageDao.add(newCard);
    }

    public Garbage chooseCardFromEntireDeck() {
        List<Garbage> allCards = garbageDao.getAll();
        List<String> allNames = new ArrayList<>();
        for (Garbage card : allCards){
            allNames.add(card.getName());
        }
        int chosenIndex = 2; // to bedzie z view po przekazaniu allNames
        return allCards.get(chosenIndex);
    }

    public void deleteChosenCard(Garbage garbageToDelete){
        garbageDao.removeByID(2);
    }

    public void editChosenCard(Garbage garbageToEdit){
        int smell = 4; //to bedzie z View po przekazaniu Stringa smell
        int recyclingTime = 5; //to bedzie z View po przekazaniu Stringa recycling
        int junkValue = 6; //to bedzie z View po przekazaniu Stringa junkvalue
        int weight = 7; //to bedzie z View po przekazaniu Stringa weight
        Garbage newCard = new Garbage(garbageToEdit.getName(), smell, recyclingTime, junkValue, weight);
        garbageDao.updateByID(garbageToEdit.getId(), newCard);
    }


}
