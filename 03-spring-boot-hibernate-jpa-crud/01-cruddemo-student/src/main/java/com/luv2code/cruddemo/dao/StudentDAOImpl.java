package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;

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
}







