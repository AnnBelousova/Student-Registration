package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;


public class TextFileIO extends JFrame {
	
	static java.io.File myFile = new java.io.File("ProgramList.txt");

	
	public  static ArrayList<String>  readPrograms() throws IOException {	
			ArrayList<String> programs = new ArrayList<String>();
			Scanner scanner = new Scanner (myFile);
			StringBuilder st = new StringBuilder();
			while(scanner.hasNextLine()) {
				String progr = scanner.nextLine();	
				programs.add(progr);			
			}
			scanner.close();
			return programs;
	}		
}

