
import java.lang.management.PlatformLoggingMXBean;
import java.util.*;

public class ServiceGame {
	private GarbageDao garbageDao = new GarbageDao();
	private CardsCollection allCards = new CardsCollection();
	private View view;


	public ServiceGame(View view){
		this.view = view;
	}


	public boolean initPlayers(ServiceGame serviceGame, ServicePlayer servicePlayer) {
		servicePlayer.setPlayers();
		if (!serviceGame.loadGarbageFromDB()) {
			view.loadDBFailed();
			return false;
		}
		if (!serviceGame.dealCardsToPlayers(servicePlayer.getPlayers())) {
			view.addMorePlayersThanCardsFailed();
			return false;
		}
		return true;
	}


	public boolean loadGarbageFromDB() {
		allCards.addCardsFromListToDeck(garbageDao.getAll());
		return allCards.getSize() != 0;
	}


	public boolean dealCardsToPlayers(List<Player> players) {
		int numberOfCards = allCards.getSize();
		int numberOfPlayers = players.size();
		if (numberOfPlayers >= numberOfCards){
			return false;
		}
		allCards.shuffleCards();
		int i = 0;
		for (Player player : players) {
			player.setAllCards(allCards.getAllCards().subList(i, i + (numberOfCards / numberOfPlayers)));
			i += numberOfCards / numberOfPlayers;
		}
		return true;
	}


	public GarbageDao getGarbageDao() {
		return garbageDao;
	}


	public void nextTour(List<Player> players) {
		boolean devTest = false;
		boolean isDraw = isPlayersDraw(players);
		if(devTest) testShowPlayersAllCards________________(players);
//		Positions choice = this.getChoice(players);

		if (!isDraw) {
			Positions choice = this.getChoice(players);
			moveCardsIntoPlayersTables(players, isDraw);
			int max = -1;
			int numberOfWinners = 0;
			max = setMax(players, choice, max);
			numberOfWinners = setNumberOfWinners(players, choice, max, numberOfWinners);
			if (numberOfWinners == 1) {
				moveCardsIntoWinner(players, choice, max);
			} else {
				for (Player player : players) {
					if (player.getTopCartFromTable().getByChoice(choice) == max) {
						player.setDraw(true);
					}
				}
			}
		} else {
			Positions choice = this.getChoice(players);
			moveCardsIntoPlayersTables(players, isDraw);
			testShowPlayersAllCards________________(players);
			int max = -1;
			int numberOfWinners = 0;
			max = setMaxIfDraw(players, choice, max);
			numberOfWinners = setNumberOfWinnersIfDraw(players, choice, max, numberOfWinners);
			if (numberOfWinners == 1) {
				moveCardsIntoWinnerIfDraw(players, choice, max);
				for (Player player : players) {
					player.setDraw(false);
				}
			} else {
				for (Player player : players) {
					if (player.isDraw() && player.getTopCartFromTable().getByChoice(choice) == max) {
						player.setDraw(true);
					} else {
						player.setDraw(false);
					}
				}
			}
		}


















	}

	private int setNumberOfWinners(List<Player> players, Positions choice, int max, int numberOfWinners) {
		for (Player player : players) {
			if (player.getTopCartFromTable().getByChoice(choice) == max) {
				numberOfWinners++;
			}
		}
		return numberOfWinners;
	}


	private int setNumberOfWinnersIfDraw(List<Player> players, Positions choice, int max, int numberOfWinners) {
		for (Player player : players) {
			if (player.isDraw() && player.getTopCartFromTable().getByChoice(choice) == max) {
				numberOfWinners++;
			}
		}
		return numberOfWinners;
	}

	private int setMax(List<Player> players, Positions choice, int max) {
		for (Player player : players) {
			if (player.getTopCartFromTable().getByChoice(choice) > max) {
				max = player.getTopCartFromTable().getByChoice(choice);
			}
		}
		return max;
	}


	private int setMaxIfDraw(List<Player> players, Positions choice, int max) {
		for (Player player : players) {
			if (player.isDraw() && player.getTopCartFromTable().getByChoice(choice) > max) {
				max = player.getTopCartFromTable().getByChoice(choice);
			}
		}
		return max;
	}


	private void moveCardsIntoWinner(List<Player> players, Positions choice, int max) {
		CardsCollection tableBuffer = new CardsCollection();
		for (Player player : players) {
			if (player.getTopCartFromTable().getByChoice(choice) == max) {
				player.setWinner(true);
				player.setPlayerTurn(true);
			} else {
				player.setPlayerTurn(false);
			}
			tableBuffer.addCardsFromListToDeck(player.getPlayerTable().getAndRemoveAllCards());
		}
		for (Player player : players) {
			if (player.isWinner()) {
				player.addCardsIntoBottomPlayerDec(tableBuffer);
				player.setWinner(false);
			}
		}
	}


	private void moveCardsIntoWinnerIfDraw(List<Player> players, Positions choice, int max) {
		CardsCollection tableBuffer = new CardsCollection();
		for (Player player : players) {
			if (player.isDraw() && player.getTopCartFromTable().getByChoice(choice) == max) {
				player.setWinner(true);
				player.setPlayerTurn(true);
			} else {
				player.setPlayerTurn(false);
			}
			tableBuffer.addCardsFromListToDeck(player.getPlayerTable().getAndRemoveAllCards());
		}
		for (Player player : players) {
			if (player.isWinner()) {
				player.addCardsIntoBottomPlayerDec(tableBuffer);
				player.setWinner(false);
			}
		}
	}


	private void moveCardsIntoPlayersTables(List<Player> players, boolean isDraw) {
		if (isDraw) {
			for (Player player : players) {
				if (player.isDraw()) {
					player.moveCardIntoTopPlayerTable();
				}
			}
		} else {
			for (Player player : players) {
				player.moveCardIntoTopPlayerTable();
			}
		}
	}


	private boolean isPlayersDraw(List<Player> players) {
		boolean isDraw = false;
		for (Player player : players) {
			if (player.isDraw()) {
				isDraw = true;
			}
		}
		return isDraw;
	}


	public boolean isPlayerLoos(List<Player> players) {
		for (Player player : players) {
			if (!player.isActive()) {
				view.looserIs(player);
				sleep(2000);
				return true;
			}
		}
		return false;
	}


	private Positions getChoice(List<Player> players) {
		for (Player player : players) {
			if (player.isPlayerTurn()) {
				return player.chooseStatisticToCompare();
			}
		}
		return Positions.ERROR;
	}


	private void testShowPlayersAllCards________________(List<Player> players) {
		Scanner scanner = new Scanner(System.in);
		for (Player player : players) {
			System.out.println(" ----------" + player.getPlayerName() + " <---Player name   " + player.isWinner() + "<---- is winter  " + player.isDraw() + " <--- is drow");
			System.out.println("-- Player dec <----------");
			for(Garbage card: player.getPlayerDeck().getAllCards())
				System.out.println(card.toString());
			System.out.println(" -- Player table <--------");
			for(Garbage card: player.getPlayerTable().getAllCards())
				System.out.println(card.toString());
		}
		scanner.nextLine();
	}


	public void sleep(int timeMilisecond){
		try
		{
			Thread.sleep(timeMilisecond);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
}

