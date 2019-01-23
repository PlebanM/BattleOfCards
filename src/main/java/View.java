import java.util.*;

public class View {

    Scanner input;
    ValidateInputs validate = new ValidateInputs();
    List<List<String>> playersList;

    public View(){
        this.input = new Scanner(System.in);
    }


    public void startGame(){
		int i = 0;
		int j = 1;
		System.out.println("Players names: ");
		for (List<String> group : playersList) {
			i++;
			for (String name: group) {

				if(i==1){
					System.out.println(j + ". Real player " + name);
				}else{
					System.out.println(j + ". AI player " + name);
				}
				j++;

			}

		}

	}


    public int showMainMenu(){
        System.out.println("MAIN MENU: \n" +
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



    public void showGameMenu(){
        Controller controller = new Controller();
        controller.runGame();

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

		String option;
		do {

			option = input.next();

		}while((!validate.validationInputInteger(0, 3, option)));


        return Integer.parseInt(option);
    }




    public int getPositionOnCard(){
    	String question = "What kind of statistics you want to use? ";
    	return validate.chooseNumber(question);

    }



    public void showAllCards(){

    }


    public void showCard() {
	}



	public List<List<String>> getPlayers() {

    	int playersCount = validate.chooseNumberGreaterThenZero("How many users will be playing?");

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
		this.playersList = allUsersNames;

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
	//todo: edycja, kasowanie i dodanie nowej karty;wybierz nazwe, wybiez statystyke
}
//todo: dostaje liste stringow->wyswietlam sytringi i zwracam index(int);
//todo: dostaje w parametrze string i int(lub nie) i robie przeciazoną metode ->zwracam int - edycja karty