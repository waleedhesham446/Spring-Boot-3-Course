package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

  // define fields for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructor injection
  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  // implement save method
  @Override
  @Transactional
  public void save(Student thStudent) {
    entityManager.persist(thStudent);
  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery("From Student ORDER BY lastName DESC", Student.class);

    // execute query and get result list
    List<Student> students = theQuery.getResultList();
    return students;
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student.class);

    // set query parameter
    theQuery.setParameter("lastName", theLastName);

    // execute query and get result list
    List<Student> students = theQuery.getResultList();

    // return the results
    return students;
  }

  @Override
  @Transactional
  public void update(Student thStudent) {
    entityManager.merge(thStudent);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    // retrieve the student
    Student theStudent = entityManager.find(Student.class, id);

    // delete the student
    entityManager.remove(theStudent);
  }

  @Override
  @Transactional
  public int deleteAll() {

    int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

    return numRowsDeleted;
  }
}







