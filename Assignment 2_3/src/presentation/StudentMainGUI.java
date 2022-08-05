package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import data.BinaryFileIO;
import data.RandomFileIO;
import data.TextFileIO;


import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class StudentMainGUI extends JFrame {
	
	private static int studId = 0;
	private static int idup=0;
	
	private JTextField txtStudId;
	private JRadioButton rdbSemester1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public StudentMainGUI() {
		getContentPane().setBackground(new Color(240, 240, 240));
		setBackground(new Color(220, 220, 220));
		setFont(new Font("Dialog", Font.BOLD, 25));
		try {
			initialize();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
		public void initialize() throws FileNotFoundException {
		this.setTitle("Student Course Registration");
		this.setBounds(250, 200, 923, 470);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblStudentId.setBounds(21, 120, 138, 40);
		getContentPane().add(lblStudentId);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProgram.setBounds(21, 171, 138, 40);
		getContentPane().add(lblProgram);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSemester.setBounds(21, 222, 138, 40);
		getContentPane().add(lblSemester);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCourses.setBounds(21, 276, 138, 42);
		getContentPane().add(lblCourses);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(452, 78, 440, 261);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		panel.setBounds(452, 78, 440, 261);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrpane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrpane);
		getContentPane().add(panel);
				
		txtStudId = new JTextField();
		txtStudId.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(txtStudId.isValid()) {
					idup = Integer.parseInt(txtStudId.getText());
					
				}else
				JOptionPane.showMessageDialog(null, "Enter ID");		
			}
		});
		
		txtStudId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtStudId.setBounds(258, 108, 190, 40);
		getContentPane().add(txtStudId);
		txtStudId.setColumns(10);
		
		JCheckBox chckbCourse1 = new JCheckBox("C1");
		chckbCourse1.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbCourse1.setBounds(194, 287, 51, 23);
		getContentPane().add(chckbCourse1);
		
		JCheckBox chckbCourse2 = new JCheckBox("C2");
		chckbCourse2.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbCourse2.setBounds(247, 287, 51, 23);
		getContentPane().add(chckbCourse2);
		
		JCheckBox chckbCourse3 = new JCheckBox("C3");
		chckbCourse3.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbCourse3.setBounds(301, 287, 51, 23);
		getContentPane().add(chckbCourse3);
		
		JCheckBox chckbCourse4 = new JCheckBox("C4");
		chckbCourse4.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbCourse4.setBounds(354, 287, 51, 23);
		getContentPane().add(chckbCourse4);
		
		JCheckBox chckbCourse5 = new JCheckBox("C5");
		chckbCourse5.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbCourse5.setBounds(403, 287, 45, 23);
		getContentPane().add(chckbCourse5);
		
		rdbSemester1 = new JRadioButton("1");
		buttonGroup.add(rdbSemester1);
		rdbSemester1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbSemester1.setBounds(194, 234, 51, 23);
		getContentPane().add(rdbSemester1);
		
		JRadioButton rdbSemester2 = new JRadioButton("2");
		buttonGroup.add(rdbSemester2);
		rdbSemester2.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbSemester2.setBounds(258, 234, 51, 23);
		getContentPane().add(rdbSemester2);
		
		JRadioButton rdbSemester3 = new JRadioButton("3");
		buttonGroup.add(rdbSemester3);
		rdbSemester3.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbSemester3.setBounds(315, 234, 51, 23);
		getContentPane().add(rdbSemester3);
		
		JRadioButton rdbSemester4 = new JRadioButton("4");
		buttonGroup.add(rdbSemester4);
		rdbSemester4.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbSemester4.setBounds(368, 234, 51, 23);
		getContentPane().add(rdbSemester4);
		
	
		//Write programs to Combobox
			JComboBox cmbProgram = new JComboBox();
			try {
				ArrayList<String> arr = TextFileIO.readPrograms();
				for(int i=0; i<arr.size(); i++) {
				cmbProgram.addItem(arr.get(i));		
				}
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			cmbProgram.setBounds(258, 171, 190, 40);
			getContentPane().add(cmbProgram);
		
		
		//Save record
		JButton btnSave = new JButton("Save");	
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String courses = "";
				
				
				String program = cmbProgram.getItemAt(cmbProgram.getSelectedIndex()).toString();
					
				int semester = 0;
				
						
				if(rdbSemester1.isSelected()) {
					semester = 1;
				}
				
				if(rdbSemester2.isSelected()) {
					 semester = 2;
				}
				
				if(rdbSemester3.isSelected()) {
					semester = 3;
				}
				
				if(rdbSemester4.isSelected()) {
					semester = 4;
				}
				
				if (chckbCourse1.isSelected()) {
					courses += "C1 ";		
				}
			
				if (chckbCourse2.isSelected()) {
					courses += "C2 ";		
				}
				
				if (chckbCourse3.isSelected()) {
					courses += "C3 ";		
				}
				
				if (chckbCourse4.isSelected()) {
					courses += "C4 ";		
				}
				
				if (chckbCourse5.isSelected()) {
					courses += "C5 ";		
				}
				
				try {
					
					RandomFileIO.writeStudent(studId, program, semester, courses);

					BinaryFileIO.writeStudent(studId, program, semester, courses);
					
					JOptionPane.showMessageDialog(null, "Student is saved.");
					
					}catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Error!" + e1.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			}		
		});
		
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(293, 345, 87, 34);
		getContentPane().add(btnSave);
			
	//DISPLAY All Rows	
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String program = cmbProgram.getItemAt(cmbProgram.getSelectedIndex()).toString();
				try {
					Object[] student = BinaryFileIO.readStudents();
					for(Object s : student) {
						txtArea.append(s.toString());
						txtArea.append("\n");
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "The list is empty");
				}
	
			}			
		});
		
	
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDisplay.setBounds(390, 345, 103, 34);
		getContentPane().add(btnDisplay);
		
		//DISPLAY FIRST Record
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					String[] student = RandomFileIO.findFirst();
					for(Object s : student) {
						txtArea.append(s.toString());
						txtArea.append("\n");
						txtStudId.setText(student[0]);
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty");					
				}				
			}
		});
		
		//DISPLAY Last Record
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {
					String[] student = RandomFileIO.findLast();
					for(Object s : student) {
						txtArea.append(s.toString());
						txtArea.append("\n");
						txtStudId.setText(student[0]);
					}		
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty");
				}
			}
		});
		
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFirst.setBounds(151, 33, 97, 34);
		getContentPane().add(btnFirst);
		
		//DISPLAY Previous Record
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtArea.getText();
				int id = 0;
				if(text.isEmpty()){
					JOptionPane.showMessageDialog(null, "You don not have any PREVIOUS record.");
					} else {
						id = Integer.parseInt(txtStudId.getText());
				try {
						String[] student = RandomFileIO.findPrevious(id);
						for(Object s : student) {
							txtArea.append(s.toString());
							txtArea.append("\n");
							txtStudId.setText(student[0]);
							
						}
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "It was first student in the list");
			}	
			}				
			}
		});
		
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPrevious.setBounds(258, 33, 128, 34);
		getContentPane().add(btnPrevious);
		
		//DISPLAY Next Record
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				String text = txtArea.getText();
				int id = 0;
				if(text.isEmpty()){
					JOptionPane.showMessageDialog(null, "You do not have any NEXT record.");
					} else {
						id = Integer.parseInt(txtStudId.getText());
				try {
						String[] student = RandomFileIO.findNext(id);
						for(Object s : student) {
							txtArea.append(s.toString());
							txtArea.append("\n");
							txtStudId.setText(student[0]);
							
						}
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "It was last student in the list");
			}	
			}
			}
		});
		
		
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNext.setBounds(396, 33, 97, 34);
		getContentPane().add(btnNext);
		
	
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLast.setBounds(503, 33, 97, 34);
		getContentPane().add(btnLast);
		
		//Update the record 
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courses = "";			
				
				String program = cmbProgram.getItemAt(cmbProgram.getSelectedIndex()).toString();				
				
				int semester = 0;			
						
				if(rdbSemester1.isSelected()) {
					semester = 1;
				}
				
				if(rdbSemester2.isSelected()) {
					 semester = 2;
				}
				
				if(rdbSemester3.isSelected()) {
					semester = 3;
				}
				
				if(rdbSemester4.isSelected()) {
					semester = 4;
				}
				
				if (chckbCourse1.isSelected()) {
					courses += "C1 ";		
				}
			
				if (chckbCourse2.isSelected()) {
					courses += "C2 ";		
				}
				
				if (chckbCourse3.isSelected()) {
					courses += "C3 ";		
				}
				
				if (chckbCourse4.isSelected()) {
					courses += "C4 ";		
				}
				
				if (chckbCourse5.isSelected()) {
					courses += "C5 ";		
				}
				
				idup = Integer.parseInt(txtStudId.getText());
			
				try {
					
					RandomFileIO.updateStudent(idup, program, semester, courses);
					JOptionPane.showMessageDialog(null, "You updated the student with ID: " + idup + "\nProgram: " + program  + "\nSemester: " + semester + "\nCourse: " + courses);
					
					}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(610, 33, 111, 34);
		getContentPane().add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(503, 345, 87, 34);
		getContentPane().add(btnExit);
		
		}	
}