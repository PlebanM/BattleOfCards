
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
		view.startGame();

		//todo 							"1. Start game\n"
		boolean isLoadGarbage = serviceGame.loadGarbageFromDB();
		boolean isSetPlayers = servicePlayer.setPlayers();
		boolean isCardsHandleToPlayers = serviceGame.dealCardsToPlayers(servicePlayer.getPlayers());

		//todo this all part is only for tests
		testShow();
		do {
			serviceGame.nextTour(servicePlayer.getPlayers());
			testShow();
			if (servicePlayer.getPlayers().size() == 0) {
				break;
			}
		} while (!servicePlayer.isWinner() || servicePlayer.isAllPlayersEmpty());
	}



	private void testShow() {
		System.out.println("----------------------");
		System.out.println(servicePlayer.getPlayers().size() + "<--- players size");
		for (Player player : servicePlayer.getPlayers()) {
			System.out.println(player.isPlayerTurn() + " : " + player.isActive() + " : " + player.getPlayerName() + " : " + player.getPlayerDeck().getAllCards());
		}
	}
}
