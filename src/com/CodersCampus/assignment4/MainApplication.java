package com.CodersCampus.assignment4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		// Notes to self
		// Collect the masterlist.txt data 					Yes
		// Separate the data by classes 					yes
		// Put the data into a csv file for each class 		yes
		// Organize the data by grade in descending order 	yes
		FileServiceImpl fileService = new FileServiceImpl();
		UserServiceImpl userService = new UserServiceImpl();
		User[] users;
		users = fileService.createStudentsFromMasterFile();
		Arrays.sort(users);
//		for (User user : users) { 			//print students to console
//			userService.logStudent(user);
//		}
		File fileCourseComp = new File("course1.csv");
		File fileCourseApMath = new File("course2.csv");
		File fileCourseStat = new File("course3.csv");
		String currentCourse = null;
		List<User> studentsInComp = new ArrayList<User>(); // Use arraylist instead since it wont work with a array
		List<User> studentsInApMath = new ArrayList<User>();
		List<User> studentsInStat = new ArrayList<User>();
		for (User user : users) {
			currentCourse = userService.checkingStudentClass(user);
			if (currentCourse.equals("COMP")) {
				studentsInComp.add(user);
			} else if (currentCourse.equals("APMATH")) {
				studentsInApMath.add(user);
			} else if (currentCourse.equals("STAT")) {
				studentsInStat.add(user);
			}
//			System.out.println(currentCourse);
		}

		fileService.writeToFile(fileCourseComp, studentsInComp);
		fileService.writeToFile(fileCourseApMath, studentsInApMath);
		fileService.writeToFile(fileCourseStat, studentsInStat);
	}

}
