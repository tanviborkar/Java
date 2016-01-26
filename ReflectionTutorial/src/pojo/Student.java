package pojo;

import java.util.List;

public class Student {
	private long studentId;
	public String studentName;
	String department;
	public int percentage;
	public List<String> courses;
	
	public Student(){
		
	}
	
	public Student(long studentId, String studentName, int percentage, List<String> courses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.percentage = percentage;
		this.courses = courses;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + ", percentage=" + percentage
				+ ", courses=" + courses + "]";
	}
}
