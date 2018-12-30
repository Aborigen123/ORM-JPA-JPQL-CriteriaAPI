package ua.orm.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	
@Column(name = "full_name")
	private String fullName;
	
@Column(name = "age")
	private int age;

 @ManyToMany
 @JoinTable(name = "student_course", 
	joinColumns = @JoinColumn(name = "student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
private List<Course> courses = new ArrayList<>();

	public Student() {
		
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


//	@Override
//	public String toString() {
//		return "Student [fullName=" + fullName + ", age=" + age + ", courses=" + courses + ", getId()=" + getId() + "]";
//	}


	
}
