import java.util.Scanner;

public class ValidateInputs {


    Scanner input;


    public ValidateInputs(){
        this.input = new Scanner(System.in);
    }


    public boolean isNumeric(String str)
    {

        return str.matches("\\d+");
    }

    public int chooseNumber(String question){
        String str;
        do {
            System.out.println(question);
            str = input.next();

        }while(!str.matches("\\d+"));

        System.out.println(str);
        return Integer.parseInt(str);
    }


    private boolean checkRange(int firstOption, int lastOption, String input ) {
        int optionInt = Integer.parseInt(input);
        if ((optionInt >= firstOption && optionInt <= lastOption) ) {

            return true;
        } else {
            System.out.println("Wrong number");
            return false;
        }

    }


    public boolean validationInputInteger(int firstOption, int lastOption, String input){

        if (this.isNumeric(input)) {
            if (this.checkRange(firstOption, lastOption, input)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("It's not a number");
            return false;
        }


    }

}
