import java.util.ArrayList;

public class Student {
	private int ID;
	private String name;
	private String address;
	private String department;
	private String[] course = new String[10];
	ArrayList<String> courseList = new ArrayList<>();
	
	public void setID(int id) {
		this.ID = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setCourse(String course,int idx) {
		this.course[idx] = course;
	}
	public void setCourseList(String course) {
		this.courseList.add(course);
	}
	
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getDepartment() {
		return department;
	}
	public String getCourse(int i) {
		return course[i];
	}
	public String getCourseList(int i) {
		return courseList.get(i);
	}
	
}
