
public class Controller {
    private ServiceGame serviceGame;
    private ServicePlayer servicePlayer;
    private View view;
    private ServiceCrud serviceCrud;


    public Controller() {
        this.view = new View();
        this.serviceGame = new ServiceGame(view);
        this.servicePlayer = new ServicePlayer(view);
        this.serviceCrud = new ServiceCrud(view, serviceGame.getGarbageDao());
    }


    public void runGame() {
        boolean gameIsOn = true;

        do {
            int mainMenuOption = view.showMainMenu();

            switch (mainMenuOption) {
                case 1:
                    boolean isLoadGarbage = serviceGame.loadGarbageFromDB();//todo: nie mozna podpiac sie pod baze
                    boolean isSetPlayers = servicePlayer.setPlayers();
                    boolean isCardsHandleToPlayers = serviceGame.dealCardsToPlayers(servicePlayer.getPlayers());//todo: wiecej uzytkowników niz kart

                    //todo this all part is only for tests
                    do {

//                        testShow();
                        view.showGameView(servicePlayer);
                        serviceGame.nextTour(servicePlayer.getPlayers());

                        sleep(1000);
//                        view.showGameView(servicePlayer);
//                        testShow();


                    } while (!servicePlayer.isWinner());
                    break;

                case 2:
                    int crudMenuOption = view.showCRUD();
                    serviceCrud.handleGeneralCrud(crudMenuOption);
                    break;

                case 3:
                    gameIsOn = false;
                    break;
            }
        } while (gameIsOn);

    }
    private void sleep(int timeMilisecond){
        try
        {
            Thread.sleep(timeMilisecond);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    private void testShow() {
        System.out.println("----------------------");
        for (Player player : servicePlayer.getPlayers()) {
            System.out.println(player.isPlayerTurn() +
                    " : " + player.isActive() +
                    " : " + player.getPlayerName() +
                    " : " + player.getPlayerDeck().getAllCards());
        }
    }
}
