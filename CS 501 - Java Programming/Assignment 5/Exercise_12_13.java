import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
  Program will prompt user to specify the file path of txt file
  Program will validate file extention is valid
  Program count the no of characters, words and lines in the file

  @author Harsh Patel
  @date 03/28/2022
 */

public class Exercise_12_13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long charsCount = 0;
        int linesCount = 0;
        int wordsCount = 0;

        int repeat = JOptionPane.YES_OPTION;
        String outputmessage = "This program will count the no of characters, words and lines in the given text file. Whitespace will not be counted in character count.";
        JOptionPane.showMessageDialog(null,outputmessage);

        while (repeat == JOptionPane.YES_OPTION) {

            JFileChooser jfilechooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXTFILE","txt");
            jfilechooser.setFileFilter(filter);
            jfilechooser.showOpenDialog(null);

            //Getting file name from the jfilechooser
            String fileName = jfilechooser.getSelectedFile().getAbsolutePath();

            try {

                //reading the file
                BufferedReader buff = new BufferedReader(new FileReader(fileName));
                String line = buff.readLine();

                //If line is not null then count the characters, words and lines
                while (line != null) {

                    linesCount++;
                    wordsCount = wordsCount + line.split(" ").length;

                    for (int i = 0; i < line.length(); i++)
                        if (!Character.isWhitespace(line.charAt(i)))
                            charsCount++;

                    line = buff.readLine();

                }

                buff.close();
                JOptionPane.showMessageDialog(null, "Total characters in the files are  : " + charsCount + "\n" + "Words are : "
                        							+ wordsCount + "\n" + "and lines are: " + linesCount);
            } catch (FileNotFoundException ex) {
                System.out.println("Exception occured : " + ex.getMessage());
            }
            repeat = JOptionPane.showConfirmDialog(null, "Do you want to Continue with another file?");
        }
	}

}
