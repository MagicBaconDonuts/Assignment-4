package com.CodersCampus.Assignment4;

public class User implements Comparable<User> {
	private String studentID;
	private String studentName;
	private String course;
	private String grade;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public int compareTo(User that) {
		if(this.grade.compareTo(that.grade) == 0) {
			return this.grade.compareTo(that.grade);
		} else {
			return that.grade.compareTo(this.grade);
		}
	}
}
