public class Controller {

	private ServicePlayer servicePlayer;
	private View view;
	private ServiceCrud serviceCrud;


	public Controller() {
		this.view = new View();
	}


	public void runGame() {
		boolean gameIsOn = true;
		do {
			switch (view.showMainMenu()) {
				case 1:
					this.servicePlayer = new ServicePlayer(view);
					ServiceGame serviceGame = new ServiceGame(view);
					this.serviceCrud = new ServiceCrud(view, serviceGame.getGarbageDao());
					if (!serviceGame.initPlayers(serviceGame, servicePlayer)) break;
					do {
						view.showGameView(servicePlayer);
						serviceGame.nextTour(servicePlayer.getPlayers());
					} while (!serviceGame.isPlayerLoos(servicePlayer.getPlayers()));
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
