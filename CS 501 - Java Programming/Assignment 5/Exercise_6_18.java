import javax.swing.*;

/*
  Program will prompt user to enter password and it will validate if password meet following requirements.
  A password must have at least eight characters.
  A password must contain only letters and digits.
  A password must contain at least two digits.

  @author Harsh Patel
  @date 03/28/2022
 */

public class Exercise_6_18{
	  
	public static void main(String[] args){
        int option= JOptionPane.YES_OPTION;
        while(option==JOptionPane.YES_OPTION){
            try{
                String password=JOptionPane.showInputDialog("Enter a Password: Must be 8 or more" +
                                							" letters or numerical digits. 2" +
                                							" of which must be digits");
                if(isValidPassword(password).equals("Valid")) {
                    option=JOptionPane.showConfirmDialog(null,
                            "Valid Password"+"\nDo you want to continue");
                }
            } 
            catch(Exception ex){
                option = JOptionPane.showConfirmDialog(null, " Invalid Password: " +ex.getMessage() +"\nDo you want to continue? ");
            }
        } 
    } 
    private static String isValidPassword(String str)throws Exception{

        //Must be 8 or more characters
        if (!(str.length() >= 8)) {
            throw new Exception("A password must have at least eight characters.");
        }
        //Must contain only alpha-numeric characters
        if (!str.matches("^[a-zA-Z0-9]+$")) {
            throw new Exception("A password must contain only letters and digits.");
        }

        //Must have at least 2 digits
        if (!str.matches("^.*?\\d.*?\\d.*$")) {
            throw new Exception("A password must contain at least two digits.");
        }
        return "Valid";

    }
}