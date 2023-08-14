import javax.swing.*;

/*
  Program will prompt user to enter string with only alphabetic characters.
  Program will validate the string
  Program will prompt user for to provide a character and it will find how many time specified character repeats
  in the string
  @author Harsh Patel
  @date 03/28/2022
 */

public class Exercise_6_23 {

	public static void main(String[] args) {

		int option= JOptionPane.YES_OPTION;
        while(option==JOptionPane.YES_OPTION){

        	//You can enter space in input
            String userInputString=JOptionPane.showInputDialog("Enter a String with only alphabetic characters");

            try{
              if(isValidString(userInputString).equals("Valid")) {

                   int repeat = JOptionPane.YES_OPTION;
                   while(repeat == JOptionPane.YES_OPTION){

                          char characterToSearch = JOptionPane.showInputDialog("Enter a character that you want to find " +
                                   											   "occurrence in the String = " + userInputString).charAt(0);
                           
                          int count = count(userInputString, characterToSearch);
                           
                          JOptionPane.showMessageDialog(null, "Your character occur " + count + " times");
                          repeat = JOptionPane.showConfirmDialog(null, "Do you want to continue " + "search for another character?");
                    }
                  option = JOptionPane.showConfirmDialog(null, "Do you want to enter another String?");
                }

            } 
            catch(Exception ex){
                option = JOptionPane.showConfirmDialog(null, " Invalid String: " +ex.getMessage() +"\nDo you want to continue? ");
            } 
        } 
    } 
    private static String isValidString(String str)throws Exception{
    	
    	// Must contain only alphabet characters
        if (!str.matches("^[a-zA-Z_\\s]+$")) {
            throw new Exception("A string must contains only alphabets");
        }

        return "Valid";

    }

    public static int count(String str, char a) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                count++;
        }
        return count;
    
	}

}
