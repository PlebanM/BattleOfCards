public class ValidateInputs {

    public boolean isNumeric(String str)
    {
        return str.matches("\\d+");
    }



    public boolean checkRange(int firstOption, int lastOption, String input ) {
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
            if (this.checkRange(1, 3, input)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Its not a number");
            return false;
        }


    }

}
