package ua.orm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.sql.Select;

import ua.orm.entity.Course;
import ua.orm.entity.Student;
import ua.orm.entity.Teacher;
import ua.orm.entity.TeacherDetails;

/**
 * 
 * @author Aborigen123
 * all comments are written in Ukrainian language
 *
 */

public class App 
{
    public static void main( String[] args ){
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");	//фабрика яка сторює пули до бд
    EntityManager em = factory.createEntityManager();// інтерфейс який забезпечує транзакцію(передачу даних)
    em.getTransaction().begin();
    

/* // заповнення бд
    TeacherDetails teacherDetails = new TeacherDetails();
    teacherDetails.setAge(29);
    teacherDetails.setFirstName("Muhamed");
    teacherDetails.setLastName("Doe");
    teacherDetails.setHobby("PC gaming");
    
    
    Teacher teacher = new Teacher();
    teacher.setLogin("Teacher_login");
    teacher.setPassword("Teacher_password");
    
    teacher.setTeacherDetails(teacherDetails);//вказуємо що створили teacherDetails і заповнюється fk
    em.persist(teacher); //збереження даниз до бд    	
    */	
    
    
    
    
  //  Teacher teacher = em.find(Teacher.class, new Long(1));
    
  //  System.out.println("Teacher > " + teacher);
  //    System.out.println("Teacher > " + teacher + "\n" + teacher.getTeacherDetails());
   // teacher.setLogin("Teacher_Id_2_login");
   // em.merge(teacher);
 


    //////////JPQL
 /** for(int i = 0; i<100; i++) { // заповнення бд
    	Teacher teacher = new Teacher("teacher_login" + i, "teacher_password" + i);
  teacher.setTeacherDetails(new TeacherDetails("First_Name" + i, "Last_Name"+i, i + 10, "PC gaming" + i));
  em.persist(teacher);
  
  Course course = new Course("course_title"+ i,"course_description" + i, new BigDecimal(i + ".99"));
  course.setTeacher(teacher);
  em.persist(course);
    }*/
   
 /*  List<Teacher> teachers = em.createQuery("SELECT c FROM Teacher c ", Teacher.class).getResultList();
    teachers.forEach(t -> System.out.println(t));*/
      

    
    
   // List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t ", Teacher.class).getResultList();
  // teachers.forEach(t -> System.out.println(t));
  
  
// List<Teacher> teachers = 
// 			em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//  		teachers.forEach(System.out::println);
  		
//  		Teacher teacher = em.createQuery("Select t from Teacher t where t.id=:id", Teacher.class)
//  				.setParameter("id", new Long(45)).getSingleResult();
//  				System.out.println(teacher);
    		



//List<Teacher> teachers = em.createQuery("Select t from Teacher t where t.login like '%2' and t.id > 10", Teacher.class)
//.getResultList();
//teachers.forEach(t -> System.out.println(t));

    
//    List<Teacher> teachers = em.createQuery("select t from Teacher t where t.id between :start and :finish", Teacher.class)
//	.setParameter("start", new Long(21))
//	.setParameter("finish", new Long(30))
//	.getResultList();
//    teachers.forEach(t -> System.out.println(t));
    
//    List<Teacher> teachers = em.createQuery("Select t from Teacher t where id IN (:ids)", Teacher.class)
//    		.setParameter("ids", Arrays.asList(new Long(23), new Long(28),new Long(4))).getResultList();
//     teachers.forEach(t -> System.out.println(t));

   
   
//	BigDecimal max = 
//	em.createQuery("SELECT max(c.price) FROM Course c", BigDecimal.class)
//	.getSingleResult();
//System.out.println("MAX: " + max);

//BigDecimal min = 
//	em.createQuery("SELECT min(c.price) FROM Course c", BigDecimal.class)
//	.getSingleResult();
//System.out.println("MIN: " + min);

//BigDecimal sum = 
//	em.createQuery("SELECT sum(c.price) FROM Course c", BigDecimal.class)
//	.getSingleResult();
//System.out.println("SUM: " + sum);

//BigDecimal sumBetween =   ?
//	em.createQuery("SELECT sum(c.price) FROM Course c "
//			+ "WHERE c.id BETWEEN ?1 AND ?2", BigDecimal.class)
//	.setParameter(1, 20)
//	.setParameter(2, 40)
//	.getSingleResult();
//System.out.println("SUM Between: " + sumBetween);

//Double avg = 
//	em.createQuery("SELECT avg(c.price) FROM Course c", Double.class).getSingleResult();
//System.out.println("AVG: " + avg);

//Long count = 
//	em.createQuery("SELECT count(c) FROM Course c", Long.class).getSingleResult();
//System.out.println("Count: " + count);

//Teacher teacher = em.createQuery("Select t from Teacher t  join t.course c where c.id  = :id", Teacher.class)
//.setParameter("id", 4L).getSingleResult();
//System.out.println(teacher);

// LIKE
// List<Teacher> teachers =
//em.createQuery("SELECT t FROM Teacher t WHERE t.firstName LIKE :teacherName", Teacher.class)
//.setParameter("teacherName", "%Name#_")
//.getResultList().forEach(System.out::println);

//em.createQuery("SELECT c FROM Course c WHERE c.title LIKE :courseTitle AND c.id >= :courseId", Course.class)
//.setParameter("courseTitle", "%8")
//.setParameter("courseId", 10)
//.getResultList().forEach(System.out::println);

// BETWEEN
//em.createQuery("SELECT t FROM Teacher t WHERE t.id BETWEEN :start AND :finish", Teacher.class)
//.setParameter("start", 45)
//.setParameter("finish", 58)
//.getResultList().forEach(System.out::println);

// IN
//em.createQuery("SELECT t FROM Teacher t WHERE t.id IN (:ids)", Teacher.class)
//.setParameter("ids", Arrays.asList(12, 34, 54, 67, 89, 90, 99, 102, 1000))
//.getResultList().forEach(System.out::println);
		
    
    
    
    /////CRITERIA API
   CriteriaBuilder cb = em.getCriteriaBuilder();
    
  //  CriteriaQuery<Course> query = cb.createQuery(Course.class);
  //  
 //   Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
 //   query.select(root); // select c from Course c
   // 
  //  List<Course> courses = em.createQuery(query).getResultList();
  //  courses.forEach(c -> System.out.println(c));
    
    
 //  CriteriaQuery<Course> query = cb.createQuery(Course.class);
   //
  // Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
 //  query.select(root); // select c from Course c
 //  
   //select c from Course c where price
//   Expression<BigDecimal> priceExpression = root.get("price");//Expression - для виконная умови (запит нижче)
//   Predicate pricePredicate = cb.ge(priceExpression, new BigDecimal("70.99")); // ge - більше рівне 70.99
   //select c from Course c where price >= 70.99
 //  query.where(pricePredicate);
 //  
//   List<Course> courses = em.createQuery(query).getResultList();
 //  courses.forEach(c -> System.out.println(c));
   
 ///////////////////////////////////////////////////////////////
   //AND
 //  Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
 //  query.select(root); // select c from Course c
   
//   //select c from Course c where price
//   Expression<BigDecimal> priceExpression = root.get("price");//Expression - для виконная умови (запит нижче)
//   Predicate pricePredicate = cb.ge(priceExpression, new BigDecimal("70.99")); // ge - більше рівне 70.99
//   Predicate pricePredicate2 = cb.le(priceExpression, new BigDecimal("80.99")); // ge - менше рівне 70.99
// // запхати в where 2 умови ми не можемо тому треба створити 3-ій предикат
//   Predicate allPredicate = cb.and(pricePredicate, pricePredicate2);//and - ми поднюємо умови
//   //select c from Course c where price >= 70.99
 //  query.where(allPredicate);
 //  
 //  List<Course> courses = em.createQuery(query).getResultList();
 //  courses.forEach(c -> System.out.println(c));
   /////////////////////////////////////////////////////////
   //Between

   //Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
 //  query.select(root); // select c from Course c
 //  Expression<BigDecimal> priceExpression = root.get("price");//Expression - для виконная умови (запит нижче)
  // Expression<Long> betweenId = root.get("id");
  // Predicate predicateId = cb.between(betweenId, new Long(5), new Long(15));
  // query.where(predicateId);
 //  
 //  
 //  List<Course> courses = em.createQuery(query).getResultList();
  // courses.forEach(c -> System.out.println(c));
  
   
 //Like
 //  Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
 //  query.select(root); // select c from Course c
 //  Expression<String> titleExpression = root.get("title");
 //  Predicate predicateTitle = cb.like(titleExpression, "%2");
 //  query.where(predicateTitle);
 //  
 //  List<Course> courses = em.createQuery(query).getResultList();
 //  courses.forEach(c -> System.out.println(c));
   
//////////////////////////////////////////////////////////// Поєнання більше і like  
// Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
//  query.select(root); // select c from Course c
 // Expression<String> titleExpression = root.get("title");
 // Expression<Long> idExpression = root.get("id");
//  Predicate predicateTitle = cb.like(titleExpression, "%2");
//  Predicate predicateId = cb.ge(idExpression, 10L);
//  Predicate predicateAll = cb.and(predicateId, predicateTitle);
//  query.where(predicateAll);
//  
 // List<Course> courses = em.createQuery(query).getResultList();
//  courses.forEach(c -> System.out.println(c));
   /////////////////////////// JOIN
   //Root<Course> root = query.from(Course.class);// з якої саме таблиці будемо діставати дані
  // query.select(root); // select c from Course c
   //
  // Join<Course, Teacher> teacherjoin = root.join("teacher");
  // Expression<Long> teacherIdJoint = teacherjoin.get("id");
 // Predicate teacherIdPredicate = cb.equal(teacherIdJoint, new Long(5));//до якої id join  
  // query.where(teacherIdPredicate);
   
 //  root.fetch("teacher");
 //  List<Course> courses = em.createQuery(query).getResultList();
 //  courses.forEach(c -> System.out.println(c));
    
   //////////////////////// JOIN-FETCH-CriteriaApi
   
   Course course = em.createQuery("Select c From Course c join fetch c.teacher t where t.id = :id ", Course.class)//join fetch - потягне 2 таблиці
   .setParameter("id", 5L).getSingleResult();
   System.out.println(course);
   
   
   
   em.getTransaction().commit();
    		
//Робочі
    		 /*   Query query = em. createQuery("SELECT c FROM Teacher ");
    	    List<String> list = query.getResultList();
    	    
    	    for(String e:list)
    	  	{
    	  		System.out.println(e);
    	  	}*/
    /*  Query query = em.
	createQuery("SELECT c.login FROM Teacher c");
  List<String> list = query.getResultList();
  
  for(String e:list)
	{
		System.out.println("Teacher NAME :"+e);
	}
  
  Query query1 = em.
			createQuery("SELECT c.login FROM Teacher c ");
	String result=(String) query1.getSingleResult();
	System.out.println(" "+result);*/
    
    	
    			
    		
    		
    em.close();
    factory.close(); // всі зєднання потрібно закривати до бд
    }
}
