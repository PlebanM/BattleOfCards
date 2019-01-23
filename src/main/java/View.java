import java.util.*;

public class View {

    Scanner input;
    ValidateInputs validate = new ValidateInputs();

    public View(){
        this.input = new Scanner(System.in);
    }

    public void showMainMenu(){
        System.out.println("MAIN MENU: \n" +
                            "1. Start game\n" +
                            "2. Edit cards\n" +
                            "3. End game\n");
        System.out.println("Choose option: ");
        validateMainMenu();
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

    public void showCRUD() {
		System.out.println("Edit menu. Choose one option: \n" +
				"1. Create new card\n" +
				"2. Delete card\n" +
				"3. Edit card\n" +
				"0. Back\n");
		System.out.println("Choose option: ");
		validateCRUD();
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

    	int playersCount = validate.chooseNumber("How many users will be playing?");

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
		//TODO: dorobic wyswietlanie imion graczy
		for (List<String> dupa : allUsersNames) {
			System.out.println(Arrays.toString(dupa.toArray()));

		}
		System.out.println("UDALO SIE");
		return allUsersNames;
	}


	public List<String> createNames(int count, String userType){
		List<String> usersList = new ArrayList<>();
    	for (int i = 0; i < count; i++){
			System.out.println("Write name of " + userType + " number " + (i+1) +": ");
    		usersList.add(input.next());
		}

    	return usersList;



	}

	public void createAINames(){

	}


	private void  validateAddUsersNames(){
//		String usersNumbers = input.next();
//
//		if(!validate.isNumeric(usersNumbers)){
//			addUsersName();
//		}
//
//		int usersNumbersInt = Integer.parseInt(usersNumbers);
//		System.out.println(usersNumbersInt);
//
//		String[] usersNames = new String[usersNumbersInt];
//		String[] AINames = new String[usersNumbersInt];
//		for(int i = 0; i < usersNumbersInt; i++ ){
//			System.out.println("Write name of Player number " + (i+1) +": ");
//			usersNames[i]=input.next();
//		}
//		System.out.println(Arrays.toString(usersNames));
//		return  usersNames;


	}





//	    //todo print and input names and set two list of Players and Ai players
//        return out;


    //todo: metoda start game -> lista imion(lista<string>)


	public void showLooseMessage(String name) {
		//todo print loose message, name is looser name
	}
	//todo: edycja, kasowanie i dodanie nowej karty;wybierz nazwe, wybiez statystyke
}
//todo: dostaje liste stringow->wyswietlam sytringi i zwracam index(int);
//todo: dostaje w parametrze string i int(lub nie) i robie przeciazoną metode ->zwracam int - edycja karty