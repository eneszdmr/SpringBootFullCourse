package com.example.cruddemo.dao;

import com.example.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("From Student order by lastName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        //böyle de olur
        //    TypedQuery<Student> liststu = entityManager.createQuery("From Student where firstName='"+firstName+"'", Student.class);

        TypedQuery<Student> findFirstName = entityManager.createQuery("From Student where firstName=:theData", Student.class);
        findFirstName.setParameter("theData", firstName);


        return findFirstName.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(int id) {
        Student found=entityManager.find(Student.class,id);
        entityManager.remove(found);

    }


}
