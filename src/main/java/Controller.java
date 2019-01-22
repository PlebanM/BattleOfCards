
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

		

	}

//		String[] AIPlayersNames = {"AiPlayer"};
//
//
//
//
//
//		for (String playerName : playerNames) {
//			userPlayers.add(new UserPlayer(playerName, view));
//		}
//		userPlayers.add(new AIPlayer("AiPlayer", view));
//
//		boolean isSetGame = service.setGame(userPlayers);
//
//
//
//
//		ServiceGame test = new ServiceGame();
//		GarbageDao testDAO = new GarbageDao();
//		List<Garbage> garbage = new ArrayList<>(testDAO.getAll());
//		List<Integer> win = test.compareGarbage(Positions.SMELL, garbage);
//		System.out.println(win);
//
//	}
//
//	public void handleCrud() {
//
//	}
}
