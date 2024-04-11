package org.example.model;

import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentRepository {


    private EntityManager entityManager;
    private EntityManagerFactory emf;
//ussual one
    public StudentRepository() {
        this.emf = Persistence.createEntityManagerFactory("database-configuration");
        this.entityManager = this.emf.createEntityManager();
    }

// for testing
    public StudentRepository(String test) {
        this.emf = Persistence.createEntityManagerFactory("database-configuration");
        this.entityManager = this.emf.createEntityManager();
    }

//jpa   ADD  java persistence API    ( API application  programming interface)
    public Student add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

// jpa find
    public Student find(Long id) {
        return entityManager.find(Student.class, id);

    }

//11.04 jpql find
    public Student findById(Long id) {
        Query query = entityManager.createNamedQuery("find student by id");
        query.setParameter("id", id);
        return (Student) query.getSingleResult();
    }

//jpql java persistence query language Update
    public Student updateFirstNameById(String firstName, Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Update Student set firstName ='" + firstName + "'where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }
//jpql update
    public Student updateLastNameById(String lastName, Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Update Student set lastName ='" + lastName + "'where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }


//jpql FILTER entity
    public List<Student> findByFirstNameStartWith(String keyword){
        Query query =entityManager.createQuery("Select s from Student  s where s.firstName like ' " + keyword + " %'");
        return query.getResultList();
    }
//jpql FILTER findBy
    public List<Student> findByLastNameEndWith(String keyword){
        Query query =entityManager.createQuery("Select s from Student  s where s.lastName like ' %" + keyword + " '");
        return query.getResultList();
    }

//jpql SORT entity -
    public List<Student> findSortingByFirstName(){
        Query query=entityManager.createQuery("Select s from Student s order by s.firstName desc");
        return query.getResultList();
    }

//jpql SORT entity
    public List<Student> findSortingByLastName(){
        Query query=entityManager.createQuery("Select s from Student s order by s.lastName desc");
        return query.getResultList();
    }

    //jpql SORT entity
    public List<Student> findSortingById(){
        Query query=entityManager.createQuery("Select s from Student s order by s.id desc");
        return query.getResultList();
    }





//jpql  COUNT
    public long count(){
        Query query=entityManager.createQuery("Select count(s) from Student s ");
        return (Long) query.getSingleResult();
    }


//jpa update
    public Student update(Student student) {
        Student studentToUpdate = find(student.getId());
        entityManager.getTransaction().begin();
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        entityManager.getTransaction().commit();
        return studentToUpdate;
    }



    public  void  deleteById(Long id){
        entityManager.getTransaction().begin();
        Query query =entityManager.createQuery("Delete from Student where id= "+ id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

//jpa delete
    public void delete(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();

    }


// jpql find
    public List<String> findFirstNames() {
        //entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select s.firstName from Student s");

        // entityManager.getTransaction().commit();
        return query.getResultList();

    }

    // jpql find
    public List<String> findLastNames() {
        //  entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select s.lastName from Student s");
        //entityManager.getTransaction().commit();

        return query.getResultList();

    }


    //10.04 jpa
    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
