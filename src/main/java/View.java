import java.util.Scanner;

public class View {

    private Scanner input;

    public View(){
        this.input = new Scanner(System.in);
    }

    public void showMainMenu(){
        String menu = "1. Start game\n" +
                "2. Edit cards\n" +
                "3. End game\n";
        System.out.println(menu);
    }

    public void showGameMenu(){

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
