package com.CodersCampus.Assignment4;

public class UserServiceImpl implements UserService {

	@Override
	public User createUser(String[] info) {
		User user = new User();
		user.setStudentID(info[0]);
		user.setStudentName(info[1]);
		user.setCourse(info[2]);
		user.setGrade(info[3]);
		return user;
	}

	@Override
	public void logStudent(User userInfo) {
		System.out.println(userInfo.getStudentID() + " " + userInfo.getStudentName() + " " +
				userInfo.getCourse() + " " + userInfo.getGrade());
		
	}

	@Override
	public String checkingStudentClass(User student) {
		if(student.getCourse().matches("COMPSCI+.[0-9]+")) {
//			System.out.println("Student is a COMPSCI Student");
			String course = "COMP";
			return course;
		}else if(student.getCourse().matches("APMTH+.[0-9]+")) {
//			System.out.println("Student is a APMTH");
			String course = "APMATH";
			return course;
		}else if(student.getCourse().matches("STAT+.[0-9]+")) {
//			System.out.println("Student is a STAT");
			String course = "STAT";
			return course;
		}
		return null;
	}

}
