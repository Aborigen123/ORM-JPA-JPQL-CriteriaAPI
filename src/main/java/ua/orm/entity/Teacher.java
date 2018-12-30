package ua.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	/**
	 * Робимо autoincrement
	 * Для бд PostgreSQL треба буде використати GenerationType.SEQUENCE
	 * Для бд MySqL  GenerationType.IDENTITY
	 */
//	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY) //FetchType.EAGER(по дефолту @ToOne) - всі дані і всі курси потяне  FetchType.LAZY(по дефолту @ToMany) - тільки teacher (при потребі доступитися до інших даних н-д teacher.getTeacherDetails)
	@JoinColumn(name = "teacher_details_id", nullable = true)//foreign key (nullable = true - дозволить вводити в колонку teacher_details_id не чекаючи id(primary key))
	private TeacherDetails teacherDetails;

	/**
	 * тут many
	 */
	@OneToMany(mappedBy = "teacher", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})//cascade - викладач видаляється курси не видаляються
	List<Course> course = new ArrayList<>();
	
	
	
	
	public Teacher(String login, String password) {
	
	
		this.login = login;
		this.password = password;
	
	
	}

	public Teacher() {}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

//	@Override
//	public String toString() {
//		return "Teacher [login=" + login + ", password=" + password + ", teacherDetails=" + teacherDetails + ", course="
//				+ course + ", getId()=" + getId() + "]";
//	}

	
	
	
	
}
