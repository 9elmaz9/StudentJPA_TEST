package org.tutorial;

import org.example.model.Student;
import org.example.model.StudentRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;


public class StudentRepositoryTest {

    private static StudentRepository repository;

    @BeforeClass
    public static void beforeClass() throws Exception {
        repository = new StudentRepository("database-configuration_test");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        repository.close();

    }


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void add() {

        Student student = new Student();
        student.setLastName("Red");
        student.setFirstName("Alan");

        repository.add(student);

        assertNotNull(student.getId());
        assertTrue(student.getId() != null);
    }

    @org.junit.Test
    public void find() {

        Student student = new Student();
        student.setLastName("Red");
        student.setFirstName("Alan");

        repository.add(student);

        assertNotNull(student);
        assertNotNull(student.getId());
        assertEquals("Red", student.getLastName());
    }

    @org.junit.Test
    public void update() {
        Student student = new Student();
        student.setLastName("Red");
        student.setFirstName("Alan");

        student = repository.add(student);

        student.setLastName("Green");
        student = repository.update(student);

        assertNotNull(student);
        assertEquals("Green", student.getLastName());
        assertEquals("Alan", student.getFirstName());

    }

 // @org.junit.Test
 // public void delete() {
 //     Student student = new Student();
 //     student.setLastName("Red");
 //     student.setFirstName("Alan");

 //     student = repository.add(student);

 //     repository.delete(student);

 //     student = repository.find(student.getId());
 //     assertNull(student);


 // }

}
