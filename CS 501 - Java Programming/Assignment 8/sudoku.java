import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * This is a program to read inputs
 * of sudoku solutions from a text file
 * and check the solutions if they are on not
 * and shows message dialog of the result.
 * 
 * @author Harsh Patel
 * @date 05/15/2022
 */
public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean continueProgram = true;
		while(continueProgram) {
		JOptionPane.showMessageDialog(null, "This program validates the given input Sudoku puzzle file.", "Program Description", JOptionPane.INFORMATION_MESSAGE);
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text file only", "txt");
		fileChooser.setFileFilter(filter);
		// Can set a different path
		fileChooser.setCurrentDirectory(new File("\\"));
		int result = fileChooser.showOpenDialog(null);
		BufferedReader bufferReader = null;

		if (result == JFileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().getPath();

			try {
				// Create object of FileReader
				FileReader inputFile = new FileReader(fileName);

				// Instantiate the BufferedReader Class
				bufferReader = new BufferedReader(inputFile);

				String line;
				int i = 0;
				int a[][] = new int[9][9];
				int x=1;
				
				while ((line = bufferReader.readLine()) != null) {
					// Reading lines from text file
					if((line.length())!=0) {
					for(int j=0;j<9;j++) {
						if(Character.getNumericValue(line.trim().charAt(j))<0 || Character.getNumericValue(line.trim().charAt(j))>9){
							JOptionPane.showMessageDialog(null,
									"Sudoku "+x+" has Wrong Input", "Result", JOptionPane.ERROR_MESSAGE);
						}
						else{int number=Character.getNumericValue(line.trim().charAt(j));
						a[i][j]=number;}
					}
					i++;
						if(i==9) {
							if(checksum(a)==0) {
								JOptionPane.showMessageDialog(null,
										"Entries are valid.", "Sudoku "+ x, JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null,
										"Entries are wrong.", "Sudoku "+ x, JOptionPane.INFORMATION_MESSAGE);
							}		
					}
					else {
						continue;
					}
					}
					else {i=0;x++;
						for(int j=0;j<9;j++) {
							for(int k=0;k<9;k++) {
								a[j][k]=0;
							}
						}
					}
				}

			}catch (Exception e) {
				JOptionPane.showMessageDialog(
						null,
				"Sorry, Try again.. Error while reading file:.\n"
						+ e.getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
		System.exit(0);
		}
		}
		
		int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to repeat the program?", "Repeat confirmation", JOptionPane.YES_NO_OPTION);
		if(confirmOption == 0)
			continueProgram = true;
		else
			continueProgram = false;
		}
		}
	
	public static int checksum(int[][] a) {
		//checks sum of all rows and column
		int check=0;
		for(int j=0;j<9;j++) {
			int sum=0;
			for(int k=0;k<9;k++) {
				sum+=a[j][k];
			}
			if(sum!=45) {
				check=1;
				break;
				}
		}
		for(int j=0;j<9;j++) {
			int sum=0;
			for(int k=0;k<9;k++){
				sum+=a[k][j];
			}
			if(sum!=45) {
				check=1;
				break;
				
				}
		}
		return check;
	}
}
