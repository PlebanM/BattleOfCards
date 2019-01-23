import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {

    Scanner input;
    ValidateInputs validate = new ValidateInputs();

    public View(){

        this.input = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("MAIN MENU: \n" +
                "1. Start game\n" +
                "2. Edit cards\n" +
                "3. End game\n");
    }

    public int chooseMainMenu(){
        System.out.println("Choose option: ");

        String option = input.next();

        if ((!validate.validationInputInteger(1, 3, option))) {
            showMainMenu();
        }
        return Integer.parseInt(option);

    }


    public void showGameMenu(){

    }

    public void showCRUD() {
        System.out.println("Edit menu. Choose one option: \n" +
                "1. Create new card\n" +
                "2. Delete card\n" +
                "3. Edit card\n" +
                "0. Back\n");
    }

    public int chooseCRUDoption(){
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
            getPositionOnCard();
        }
        return Integer.parseInt(option);
    }

    public void showAllCards(){

    }


    public void showCard(Garbage card){

        StringBuilder strBuild = new StringBuilder();
        strBuild.append("Card name: " + card.getName())
                .append(System.getProperty("line.separator"))
                .append("Smell: " + card.getSmell())
                .append(System.getProperty("line.separator"))
                .append("Recykling time: " + card.getRecyclingTime())
                .append(System.getProperty("line.separator"))
                .append("Junk value: " + card.getJunkValue())
                .append(System.getProperty("line.separator"))
                .append("Weight: " + card.getWeight())
                .append(System.getProperty("line.separator"));
    }

    public void addUsersName() {
        System.out.println("How many users will be playing?");
        validateAddUsersNames();
    }


     public String[]  validateAddUsersNames(){
        String usersNumbers = input.next();
        

        if(!validate.isNumeric(usersNumbers)){
            addUsersName();
        }

        int usersNumbersInt = Integer.parseInt(usersNumbers);
        System.out.println(usersNumbersInt);
        String[] usersNames = new String[usersNumbersInt];

        for(int i = 0; i < usersNumbersInt; i++ ){
            System.out.println("Write name of Player number " + (i+1) +": ");
            usersNames[i]=input.next();
        }
         System.out.println(Arrays.toString(usersNames));
        return  usersNames;


    }
    //todo: metoda start game -> lista imion(lista<string>)


}
