import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner s;

	public static void main(String[] args) throws IOException {
		
		
		int numRows = 0;
		int numColumns = 0;
		String filename = "";
		
		System.out.println("\n");
		
		
		System.out.println("GenerateData utility for JMeter");
		System.out.println("\tBy James Snee");
		System.out.println("-------------------------------\n\n");
		s  = new Scanner(System.in);
		System.out.printf("Please enter filename (without extension): ");
		filename = s.next();
		filename = filename + ".csv";
		System.out.printf("Please enter amount of rows to generate: ");
		numRows = s.nextInt();
		System.out.printf("Please enter amount of columns to generate: ");
		numColumns = s.nextInt();
		
		//create arraylist of strings for column names
		ArrayList<String> columnNames = new ArrayList<String>();
		//create int array if we need to iterate field
		int[] flags = new int[numColumns];
		
		
		for(int j = 0; j < numColumns; j++){
			System.out.printf("Please enter name for field " + (j+1) + ": ");
			String input = s.next();
			columnNames.add(input);
			System.out.printf("Would you like to iterate this field Y/N? ");
			String iterOption = s.next();
			//check input for iteration
			if(iterOption.equals("Y") || iterOption.equals("y")){
				flags[j] = 1;
			}
			else if(iterOption.equals("N") || iterOption.equals("n")){
				flags[j] = 0;
			}
			else {
				System.out.println("Error: input is not valid, defaulting to iteration...");
				flags[j] = 1;
			}
		}
		
		
		File file = new File(filename);
		
		//if file exists, create new file regardless
		if(file.exists()){
			file.createNewFile();
			
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		
		//add one to each and add to line
		for(int i = 0; i < numRows; i++){
			
			int count = 0;
			
			for(String val : columnNames){
				
				//if we have set this column to iterate, append number to end
				if(flags[count] == 1){
					bw.write(val + i + ",");
					count++;
				}
				else {
					bw.write(val + ",");
					count++;
				}
				
				
			}
			
			bw.newLine();

			
		}
		
		bw.close();
		System.out.println("File " + filename + " written!\n");

	}

}
