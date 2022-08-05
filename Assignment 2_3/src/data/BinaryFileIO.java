package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFrame;

public class BinaryFileIO extends JFrame {
	
	private static File myFile = new File("Student.dat");
	
	public static void writeStudent(int studId, String program, int semester, String courses) throws IOException {
			
			try(DataOutputStream dOut = new DataOutputStream(new FileOutputStream(myFile,true))) {
				
				int studIdN = RandomFileIO.studIdN;			
				dOut.writeInt(studIdN);
				dOut.writeUTF(program);
				dOut.writeInt(semester);
				dOut.writeUTF(courses);	 		
			}
		}
	
	public static Object[] readStudents() throws IOException {
		ArrayList<String> students = new ArrayList<String>();
		
		try(DataInputStream dIn = new DataInputStream(new FileInputStream(myFile))) {
				
			while(dIn.available() > 0){				
				int studId = dIn.readInt();
				String program = dIn.readUTF();
				int semester = dIn.readInt();
				String courses = dIn.readUTF();
				students.add(studId + ", "  + program + ", " + semester +  ", " + courses );
			}
		}
		return students.toArray();
	}
}