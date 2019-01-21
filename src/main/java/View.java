import java.util.Collections;
import java.util.Scanner;

public class View {

    Scanner input;

    public View(){
        this.input = new Scanner(System.in);
    }

    public void showMainMenu(){
        System.out.println("1. Start game");
        System.out.println("2. Edit cards");
        System.out.println("3. End game");


    }

    public void showGameMenu(){
        Controller controller = new Controller();
        controller.setGame();

    }

    public void showCRUD(){
        System.out.println("Edit menu. Choose one option: ");

        System.out.println("1. Create new card");
        System.out.println("2. Delete card");
        System.out.println("3. Edit card");
        System.out.println("4. Back");

    }

    public void getPositionOnCard(){
        System.out.println("What kind of statistics you want to use? ");

    }

    public void showAllCards(){

    }
}
