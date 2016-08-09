import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		int numRows = 0;
		
		Scanner s = new Scanner(System.in);
		System.out.printf("Please enter amount of rows to generate: ");
		numRows = s.nextInt();
		System.out.printf("Please enter a username to generate: ");
		String username = s.next();
		
		File file = new File("data.csv");
		
		//if file exists, create new file regardless
		if(file.exists()){
			file.createNewFile();
			
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuilder sb = new StringBuilder();
		sb.append(username);
		
		for(int i = 0; i < numRows; i++){
			
			bw.write(username + i + ",");
			bw.newLine();
			
		}
		
		bw.close();
		System.out.println("File data.csv written!\n");

	}

}
