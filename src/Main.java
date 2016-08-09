import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		int numRows = 0;
		int numColumns = 0;
		String filename = "";
		
		Scanner s = new Scanner(System.in);
		System.out.printf("Please enter filename: ");
		filename = s.next();
		filename = filename + ".csv";
		System.out.printf("Please enter amount of rows to generate: ");
		numRows = s.nextInt();
		System.out.printf("Please enter amount of columns to generate: ");
		numColumns = s.nextInt();
		
		//create arraylist of strings for column names
		ArrayList<String> columnNames = new ArrayList<String>();
		
		for(int j = 1; j <= numColumns; j++){
			System.out.printf("Please enter name for field " + j + ": ");
			String input = s.next();
			columnNames.add(input);
		}
		
		
		File file = new File(filename);
		
		//if file exists, create new file regardless
		if(file.exists()){
			file.createNewFile();
			
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuilder sb = new StringBuilder();
		//add one to each and add to line
		for(int i = 0; i < numRows; i++){
			
			for(String val : columnNames){
				bw.write(val + i + ",");
				
			}
			
			bw.newLine();

			
		}
		
		bw.close();
		System.out.println("File " + filename + " written!\n");

	}

}
