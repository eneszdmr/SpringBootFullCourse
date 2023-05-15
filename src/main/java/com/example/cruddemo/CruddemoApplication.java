package com.example.cruddemo;

import com.example.cruddemo.Entity.Student;
import com.example.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO dao){
		return runner -> {
			//createStudent(dao);
			//createMultipleStudents(dao);
			//readTheStudent(dao);
			//listStudent(dao);
			getFirstName(dao);
		};


	}

	private void getFirstName(StudentDAO dao){
		Student b=dao.findByFirstName("zan");
		System.out.println(b);
	}

	private void listStudent(StudentDAO dao){
		List<Student> liste=dao.findAll();

		for(Student stu : liste){
			System.out.println(stu);
		}
	}

	private void readTheStudent(StudentDAO dao){
		Student a=dao.findById(5);
		System.out.println(a);
	}

	private void createMultipleStudents(StudentDAO dao) {
		Student student=new Student("ahmet","can","ahmetcan@gmail.com");
		dao.save(student);

		Student student1=new Student("ayşe","tan","aysetan@gmail.com");
		dao.save(student1);

		Student student2=new Student("fatma","zan","fatmaan@gmail.com");
		dao.save(student2);
	}

	public void createStudent(StudentDAO studentDao){
		System.out.println("veritabanına student kaydedilecek");
		Student student=new Student("ali","veli","aliveli@gmail.com");
		studentDao.save(student);
		System.out.println("kaydedildi "+student.getId());

	}

}
