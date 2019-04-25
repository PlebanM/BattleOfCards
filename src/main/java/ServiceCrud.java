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
                System.out.println(" ");
                break;
        }
    }

    public void createNewCard() {

        String newName = view.createCardName();
        int smell = view.createStatistic("smell");
        int recyclingTime = view.createStatistic("recycling time");
        int junkValue = view.createStatistic("junk value");
        int weight = view.createStatistic("weight");
        Garbage newCard = new Garbage(newName, smell, recyclingTime, junkValue, weight);
        garbageDao.add(newCard);
    }

    public Garbage chooseCardFromEntireDeck() {
        List<Garbage> allCards = garbageDao.getAll();
        List<String> allNames = new ArrayList<>();
        for (Garbage card : allCards){
            allNames.add(card.getName());
        }
        int chosenIndex = view.chooseCardByName(allNames);
        return allCards.get(chosenIndex);
    }

    public void deleteChosenCard(Garbage garbageToDelete){

        garbageDao.removeByID(garbageToDelete.getId());
    }

    public void editChosenCard(Garbage garbageToEdit){
        int smell = view.editCardParams(garbageToEdit.getSmell(), "smell");
        int recyclingTime = view.editCardParams(garbageToEdit.getRecyclingTime(), "recycling time");
        int junkValue = view.editCardParams(garbageToEdit.getJunkValue(), "junk value");
        int weight = view.editCardParams(garbageToEdit.getWeight(), "weight");
        Garbage newCard = new Garbage(garbageToEdit.getName(), smell, recyclingTime, junkValue, weight);
        garbageDao.updateByID(garbageToEdit.getId(), newCard);
    }


}
