
public class Controller {
	private ServiceGame serviceGame;
	private ServicePlayer servicePlayer;
	private View view;


	public Controller() {
		this.view = new View();
		this.serviceGame = new ServiceGame(view);
		this.servicePlayer = new ServicePlayer(view);
	}


	public void runGame() {
		view.showMainMenu();

		//todo 							"1. Start game\n"
		boolean isLoadGarbage = serviceGame.loadGarbageFromDB();
		boolean isSetPlayers = servicePlayer.setPlayers();
		boolean isCardsHandleToPlayers = serviceGame.dealCardsToPlayers(servicePlayer.getPlayers());

		//todo this all part is only for tests
		do {

			testShow();

			serviceGame.nextTour(servicePlayer.getPlayers());

			testShow();


		} while (!servicePlayer.isWinner());
	}

	private void testShow() {
		System.out.println("----------------------");
		for (Player player : servicePlayer.getPlayers()) {
			System.out.println(player.isPlayerTurn() + " : " + player.isActive() + " : " + player.getPlayerName() + " : " + player.getPlayerDeck().getAllCards());
		}
	}
}
