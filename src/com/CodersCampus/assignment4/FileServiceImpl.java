package com.CodersCampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileServiceImpl implements FileService {

	@Override
	public User[] createStudentsFromMasterFile() {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("MasterList.csv"));
			String storedUserInformationFromFile;
			UserServiceImpl  userService = new UserServiceImpl();
			String storingKeyFeilds = fileReader.readLine();
			User[] users = new User[100];
			for(int i = 0; i < 100; i++) {
				storedUserInformationFromFile = fileReader.readLine();
				users[i] = userService.createUser(storedUserInformationFromFile.split(","));
			} return users;
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a IO Expection");
			e.printStackTrace();
		} finally{
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("There was a IO Exception in the fileRead.close()");
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void writeToFile(File file, List<User> students) throws IOException {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("Student ID,Student Name,Course,Grade\n");
			for(User student: students) {
				writer.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse() + 
						"," + student.getGrade() + "\n");
			}
		} finally{
			if(writer != null) writer.close();
		}
	}

}
