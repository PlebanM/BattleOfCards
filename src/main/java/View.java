import java.util.*;

public class View {
    private Scanner input;
    private ValidateInputs validate = new ValidateInputs();


	public View(){
        this.input = new Scanner(System.in);
    }


    public int showMainMenu(){
	    System.out.print("\033[H\033[2J");
	    System.out.println("MAIN MENU:\n" +
                            "1. Start game\n" +
                            "2. Edit cards\n" +
                            "3. End game\n");
        System.out.println("Choose option: ");
        return validateMainMenu();
    }


	private int validateMainMenu(){
		String option;
		do {
			option = input.next();
		}while((!validate.validationInputInteger(1, 3, option)));
		return Integer.parseInt(option);
	}


    public int showCRUD() {
		System.out.println("Edit menu. Choose one option: \n" +
				"1. Create new card\n" +
				"2. Delete card\n" +
				"3. Edit card\n" +
				"0. Back\n");
		System.out.println("Choose option: ");
		return validateCRUD();
	}


	private int validateCRUD(){
		String option = "";
		do {
			option = input.next();

		}while((!validate.validationInputInteger(0, 3, option)));
        return Integer.parseInt(option);
    }


	public List<List<String>> getPlayers() {
    	int playersCount = validate.chooseNumberGreaterThen("How many users will be playing?", 0);
		int userCount;
    	do{
    		userCount = validate.chooseNumber("How many real players? [max: " + playersCount + "]");
    	}while(!(userCount<=playersCount && userCount >= 0));
    	List<String> usersList = createNames(userCount, "Player");
    	int AICount = playersCount-userCount;
		List<String> AIList = createNames(AICount, "AI");
		List<List<String>> allUsersNames = new ArrayList<>();
		allUsersNames.add(usersList);
		allUsersNames.add(AIList);
		List<List<String>> playersList = allUsersNames;
		return playersList;
	}


	private List<String> createNames(int count, String userType){
		List<String> usersList = new ArrayList<>();
    	for (int i = 0; i < count; i++){
			System.out.println("Write name of " + userType + " number " + (i+1) +": ");
    		usersList.add(input.next());
		}
    	return usersList;
	}


	public void showLooseMessage(String name) {
		System.out.println("Player " + name + " loose the game!:-(");
	}


	public void showGameView(ServicePlayer servicePlayer){
		System.out.print("\033[H\033[2J");
//		System.out.println(servicePlayer.getPlayers() + " <--------------------------- getPlayers");
		for (Player player : servicePlayer.getPlayers()) {
			if(player.isPlayerTurn()){
				System.out.println("Player " + player.getPlayerName() +
						" have "+ player.getPlayerDeck().getSize() + " cards.\n" +
						"Choose statistic to compare.\n\n " +
						"Card name is: " + player.getPlayerDeck().getTopCard().getName()+"\n" +
						"*******Card STATS***********" +"\n" +
						"1. SMELL: \t\t" + player.getPlayerDeck().getTopCard().getSmell()+ "\n" +
						"2. RECYCLING TIME: \t" + player.getPlayerDeck().getTopCard().getRecyclingTime() +"\n" +
						"3. JUNK VALUE: \t\t" + player.getPlayerDeck().getTopCard().getJunkValue() +"\n" +
						"4. WEIGHT: \t\t" + player.getPlayerDeck().getTopCard().getWeight() +"\n" +
						"*****************************");
			}
		}
	}


	public void looserIs(Player player) {
		System.out.println("Looser is " + player.getPlayerName());
	}


	public String createCardName(){
		System.out.println("What name you choose for the card? ");
		String cardName = input.next();
		return cardName;
	}

	public int createStatistic(String statisticName){
		return validate.chooseNumberGreaterThen("Enter value of the " +
				statisticName + ": ", -1);
    }


    public int chooseCardByName(List<String> cards){
		int i = 0;
    	for (String name : cards) {
			i++;
    		System.out.println(i + "." + name);
		}
		System.out.println("What number of card do you choose? ");
		String option;
		do {
			option = input.next();
		}while((!validate.validationInputInteger(1, i, option)));
		return Integer.parseInt(option)-1;
	}
	public int editCardParams(int statValue, String optionName){
		System.out.println("Actual value of " + optionName + " is: " + statValue );
		int answer = validate.chooseNumberGreaterThen("Enter new value of the " +
				optionName + ": [enter = no change]", -1, statValue);
		return answer;

	}

	public int chooseStatisticToCompare(){
		String option;
		do {
			System.out.println("Which stat do you want compare with your opponents?");
			option = input.next();
		}while((!validate.validationInputInteger(1, 4, option)));
		return Integer.parseInt(option);
	}


	public void addMorePlayersThanCardsFailed(){
		System.out.println("To many players. Add new cards or less players.");
	}


	public void loadDBFailed(){
		System.out.println("No connection with DB!");
	}

	public void oponentStat(int userStatNumber){
//		System.out.println("Another Player stat is: " + player.getPlayerDeck().getTopCard().getByChoice(Positions.values()[]););
	}
}
