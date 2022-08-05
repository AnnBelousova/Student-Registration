package data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class RandomFileIO extends JFrame {
	static java.io.File myFile = new java.io.File("StudentR.dat");
	
	public static final int STUDID_SIZE = 4;
	public static final int PROGRAM_SIZE = 20;
	public static final int SEMESTER_SIZE = 4;
	public static final int COURSE_SIZE = 16;
	public static int studIdN;
	public static final int REC_SIZE =  4 + PROGRAM_SIZE*2 +  4 + COURSE_SIZE * 2 ;
	
	public static void writeStudent(int studId, String program, int semester, String courses) throws IOException {
	
	try(RandomAccessFile dOut = new RandomAccessFile(myFile,"rw")){
			
				int numRecs = (int)dOut.length()/REC_SIZE;
				studIdN = numRecs+1;
							
				dOut.seek(dOut.length());
				
				dOut.writeInt(studIdN);
				
				if(program.length()<PROGRAM_SIZE) {
				
				StringBuilder tempName = new StringBuilder(program);
								
				for (int i=0; i <PROGRAM_SIZE - program.length() ; i++) {
					tempName.append('\0');
				}
				program = tempName.toString();
				String formatP = "%." + PROGRAM_SIZE + "s";
				String studP =tempName.toString();
				dOut.writeChars(String.format(formatP, studP));	 
				}
			
				dOut.writeInt(semester);

				if(courses.length()<COURSE_SIZE) {
				StringBuilder tempName = new StringBuilder(courses);	
				for (int i=0; i <COURSE_SIZE - courses.length() ; i++) {
					tempName.append('\0');
				}
				courses = tempName.toString();
				String formatP = "%." +COURSE_SIZE + "s";
				String studC =tempName.toString();
				dOut.writeChars(String.format(formatP, studC));
			}
		}
	}
		
	
	public static String[] findFirst() throws IOException {
		String [] studentNew = new String[4];
		
		try(RandomAccessFile dIn = new RandomAccessFile(myFile,"r")) {

			//Find number of records in a file
				int numRecs = (int)dIn.length()/REC_SIZE;
				
				if(numRecs > 0) {
				dIn.seek((0) * REC_SIZE);
				StringBuilder sbProgram = new StringBuilder();
				StringBuilder sbCourse = new StringBuilder();
						
				int studId = dIn.readInt();
				studentNew[0] = Integer.toString(studId);
				
				for(int i=0; i<PROGRAM_SIZE; i++) {
					char nameChar = dIn.readChar();

					sbProgram.append(nameChar);
					}
				studentNew[1] = sbProgram.toString();

				int semester = dIn.readInt();
				studentNew[2] = Integer.toString(semester);
				
				for (int i=0; i<COURSE_SIZE; i++) {
					char nameChar = dIn.readChar();
					sbCourse.append(nameChar);
					}
				studentNew[3] = sbCourse.toString();
		
		}else 
			throw new IOException("Invalid record number");	
				
		}
		return studentNew;
	}	
	
	
	public static String[] findLast() throws IOException {
		String [] studentNew = new String[4];
		
		try(RandomAccessFile dIn = new RandomAccessFile(myFile,"r")) {

			//Find number of records in a file
				int numRecs = (int)dIn.length()/REC_SIZE;
				
				if(numRecs > 0) {
				dIn.seek((numRecs - 1) * REC_SIZE);
				StringBuilder sbProgram = new StringBuilder();
				StringBuilder sbCourse = new StringBuilder();				
			
				int studId = dIn.readInt();
				studentNew[0] = Integer.toString(studId);
							
				for(int i=0; i<PROGRAM_SIZE; i++) {
					char nameChar = dIn.readChar();

					sbProgram.append(nameChar);
					}
				studentNew[1] = sbProgram.toString();

				int semester = dIn.readInt();
				studentNew[2] = Integer.toString(semester);
				
				
				for (int i=0; i<COURSE_SIZE; i++) {
					char nameChar = dIn.readChar();
					sbCourse.append(nameChar);
					}
				studentNew[3] = sbCourse.toString();
		
		}else 
			throw new IOException("Invalid record number");
							
		}
		return studentNew;
	}
	
	
	public static String[] findNext(int id) throws IOException {
		String [] studentNew = new String[4];
		
		try(RandomAccessFile dIn = new RandomAccessFile(myFile,"r")) {
			
			int numRecs = (int)dIn.length()/REC_SIZE;
			
			if(numRecs<REC_SIZE) {
				dIn.seek((id) * REC_SIZE);
			
				StringBuilder sbProgram = new StringBuilder();
				StringBuilder sbCourse = new StringBuilder();
				
			
				int studId = dIn.readInt();
				studentNew[0] = Integer.toString(studId);
				
				
				for(int i=0; i<PROGRAM_SIZE; i++) {
					char nameChar = dIn.readChar();

					sbProgram.append(nameChar);
					}
				studentNew[1] = sbProgram.toString();

				int semester = dIn.readInt();
				studentNew[2] = Integer.toString(semester);
				
				
				for (int i=0; i<COURSE_SIZE; i++) {
					char nameChar = dIn.readChar();
					sbCourse.append(nameChar);
					}
				studentNew[3] = sbCourse.toString();		
		}else 
			throw new IOException("Invalid record number");
					
			
		}
		return studentNew;
	}	
	
	public static String[] findPrevious(int id) throws IOException {
		String [] studentNew = new String[4];
		
		try(RandomAccessFile dIn = new RandomAccessFile(myFile,"r")) {
			
			int numRecs = (int)dIn.length()/REC_SIZE;
			
			if(numRecs<REC_SIZE) {
				dIn.seek((id-2) * REC_SIZE);
				
				StringBuilder sbProgram = new StringBuilder();
				StringBuilder sbCourse = new StringBuilder();
				
			
				int studId = dIn.readInt();
				studentNew[0] = Integer.toString(studId);
				
				
				for(int i=0; i<PROGRAM_SIZE; i++) {
					char nameChar = dIn.readChar();

					sbProgram.append(nameChar);
					}
				studentNew[1] = sbProgram.toString();

				int semester = dIn.readInt();
				studentNew[2] = Integer.toString(semester);
				
				
				for (int i=0; i<COURSE_SIZE; i++) {
					char nameChar = dIn.readChar();
					sbCourse.append(nameChar);
					}
				studentNew[3] = sbCourse.toString();
	
		}else 
			throw new IOException("Invalid record number");
					
		}
		return studentNew;
	}
	
	
	public static void updateStudent(int idup, String program, int semester, String courses) throws IOException {
		String [] studentNew = new String[4];
		
		try(RandomAccessFile dOut = new RandomAccessFile(myFile,"rw")){
				
					dOut.seek((idup-1) * REC_SIZE);;
					
					String clear = "";
					studentNew[0]= clear;
					dOut.writeInt(idup);
					
					studentNew[1]= clear;
					if(program.length()<PROGRAM_SIZE) {		
					StringBuilder tempName = new StringBuilder(program);					
					for (int i=0; i <PROGRAM_SIZE - program.length() ; i++) {
						tempName.append('\0');		
					}					
					program = tempName.toString();
					String formatP = "%." + PROGRAM_SIZE + "s";
					String studP =tempName.toString();
					dOut.writeChars(String.format(formatP, studP));	 
					}

					studentNew[2]= clear;
					dOut.writeInt(semester);
					
					studentNew[3]= clear;
					if(courses.length()<COURSE_SIZE) {
					StringBuilder tempName = new StringBuilder(courses);	
					for (int i=0; i <COURSE_SIZE - courses.length() ; i++) {
						tempName.append('\0');
					}
					courses = tempName.toString();
					String formatP = "%." +COURSE_SIZE + "s";
					String studC =tempName.toString();
					dOut.writeChars(String.format(formatP, studC));
				}
			}
		}
}
