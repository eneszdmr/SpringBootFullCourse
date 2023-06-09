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
    public CommandLineRunner commandLineRunner(StudentDAO dao) {
        return runner -> {
            //createStudent(dao);
           createMultipleStudents(dao);
            // readTheStudent(dao);
            //listStudent(dao);
            //getFirstName(dao);
            //updateTheStu(dao);

         //   deleteStudent(dao);

           // sayiTekmi(1561464);

        };


    }

    private void sayiTekmi(int sayi) {
        if((sayi % 2 )== 0){
            System.out.println("Sayı çift");
        }else
        System.out.println("sayı tek");
    }

    private void deleteStudent(StudentDAO dao) throws InterruptedException {

        int studentId = 1;
        System.out.println("we want to delete the student id : " + studentId);
        System.out.println("all students here : .....");
        listStudent(dao);
        Thread.sleep(3000);
        dao.delete(studentId);
        System.out.println("deleted " + studentId);
        Thread.sleep(2000);
        listStudent(dao);
    }

    private void updateTheStu(StudentDAO dao) throws InterruptedException {

        int studentId = 7;

        Student foundStudent = dao.findById(studentId);

        System.out.println("Student searching..");

        System.out.println("Student searching....");

        System.out.println("Student searching.........");
        Thread.sleep(3000);
        System.out.println("Yeppp found it !");
        System.out.println("the student is : " + foundStudent);
        Thread.sleep(2000);
        foundStudent.setFirstName("ali updated");
        dao.update(foundStudent);
        Thread.sleep(3000);
        System.out.println("new firstname is : " + foundStudent.getFirstName());
        Thread.sleep(3000);
        System.out.println(foundStudent);

    }

    private void getFirstName(StudentDAO dao) {
        List<Student> findStudent = dao.findByFirstName("fatma");

        for (Student stu : findStudent) {
            System.out.println(stu);
        }

    }

    private void listStudent(StudentDAO dao) {
        List<Student> liste = dao.findAll();

        for (Student stu : liste) {
            System.out.println(stu);
        }
    }

    private void readTheStudent(StudentDAO dao) {
        Student a = dao.findById(5);
        System.out.println(a);
    }

    private void createMultipleStudents(StudentDAO dao) {
        Student student = new Student("emre ", "kednirci", "ahmetcan@gmail.com");
        dao.save(student);

        Student student1 = new Student("onur", "fikret", "aysetan@gmail.com");
        dao.save(student1);

        Student student2 = new Student("mücaahit", "nezdil", "fatmaan@gmail.com");
        dao.save(student2);
    }

    public void createStudent(StudentDAO studentDao) {
        System.out.println("veritabanına student kaydedilecek");
        Student student = new Student("ali", "veli", "aliveli@gmail.com");
        studentDao.save(student);
        System.out.println("kaydedildi " + student.getId());

    }

}
