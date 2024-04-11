package org.example;

import org.example.model.Student;
import org.example.model.StudentRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Student student = new Student();
        student.setFirstName("Alan");
        student.setLastName("Red");


        StudentRepository repository = new StudentRepository();

        repository.add(student);

        System.out.println("Added student" + student.toString());

//11.04 jpql find
        // List<String> firsttNames = repository.findFirstNames();
        // List<String> lastNames = repository.findLastNames();

        repository.findFirstNames().forEach(System.out::println);

        repository.findLastNames().forEach(System.out::println);


//jpa find
        student = repository.find(student.getId());

        System.out.println("Found student " + student.toString());

//11.04 jpql
        student = repository.findById(student.getId());

        System.out.println("Found student (JPQL)" + student.toString());

//10.04 jpa update
        student.setLastName("Green");

        repository.update(student);

        System.out.println("Updated student " + student.toString());

//jpql update firstname
        student = repository.updateFirstNameById("Fred", student.getId());

        System.out.println("Updated first name ( JPQL) " + student.toString());


//filter entity jpql FindBY
        List<Student> students = repository.findByFirstNameStartWith("Fr");
        students.forEach(System.out::println);

//filter entity jpql FindBY
        repository.findByLastNameEndWith("ow");
        students.forEach(System.out::println);

//jpql COUNT
        System.out.println("Number of student (s):" + repository.count());


//jpql update lastname
        student = repository.updateLastNameById("Yellow", student.getId());

        System.out.println("Updated last name (JPQL) " + student.toString());

//jpql SORT
        students = repository.findSortingByFirstName();
        students.forEach(System.out::println);
//jpql SORT
        students = repository.findSortingByLastName();
        students.forEach(System.out::println);

        //jpql SORTING BY ID
        students = repository.findSortingById();
        students.forEach(System.out::println);



//jpql delete
        // repository.deleteById(student.getId());


//jpa delete
        // coz i write jpql :
        // repository.delete(student);

        System.out.println("Deleted student " + student.toString());

        repository.close();
    }

}
