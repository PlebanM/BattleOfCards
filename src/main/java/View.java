import java.util.*;

public class View {

	Scanner input;
	ValidateInputs validate = new ValidateInputs();

	public View(){
		this.input = new Scanner(System.in);
	}

	public int showMainMenu(){
		System.out.println("MAIN MENU: \n" +
							"1. Start game\n" +
							"2. Edit cards\n" +
							"3. End game\n");
		System.out.println("Choose option: ");

		String option = input.next();

		if ((!validate.validationInputInteger(1, 3, option))) {
			showMainMenu();
		}
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


		String option = input.next();
		if ((!validate.validationInputInteger(0, 3, option))) {
			showCRUD();
		}
		return Integer.parseInt(option);
	}




	public int getPositionOnCard(){
		System.out.println("What kind of statistics you want to use? ");

		String option = input.next();

		if ((!validate.validationInputInteger(1, 4, option))) {
			showMainMenu();
		}
		return Integer.parseInt(option);
	}

	public void showAllCards(){

	}


	public void showCard(){

	}



	public void showAddPlayersMenu() {
	    //todo print short info how input users, fir
		// st question Ai or user, second name and quit or Q for quit
    }


	public List<List<String>> getPlayers() {
        List<String> AIPlayers = new ArrayList<>(Collections.singletonList("AIP"));
        List<String> userPlayers = new ArrayList<>(Arrays.asList("les", "ple"));
        List<List<String>> out = new ArrayList<>();
        out.add(userPlayers);
        out.add(AIPlayers);

	    //todo print and input names and set two list of Players and Ai players
        return out;
    }


	public void showLooseMessage(String name) {
		//todo print loose message, name is looser name
	}

}
