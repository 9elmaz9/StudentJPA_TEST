### Project: Student Management System

![Student Management System](https://i.pinimg.com/originals/6a/48/0f/6a480fcb9da63b92560ea2c83b9062cd.jpg)

The Student Management System project aims to manage student records and perform various operations using Java Persistence API (JPA) and Java Persistence Query Language (JPQL). This application allows users to add, find, update, filter, sort, and delete student records stored in a database.

#### Features:
1. **Adding Students:** Users can add new student records specifying details such as first name and last name.
   
2. **Finding Students:** Users can find students by their names, last names, or unique identifiers (IDs).
   
3. **Updating Student Information:** Student information, such as their last names, can be updated as needed.
   
4. **Filtering Students:** The system allows filtering students based on specific criteria, such as names starting with a certain letter or last names ending with a specific pattern.
   
5. **Counting Students:** Users can retrieve the total number of student records stored in the database.
   
6. **Sorting Students:** The application supports sorting students by various attributes such as first name, last name, or unique identifier.
   
7. **Deleting Students:** Student records can be deleted from the database as needed.

#### Usage:
- **Adding Students:** Create a new `Student` object with the required data and add it to the `StudentRepository`.
  
- **Finding Students:** Use the methods in `StudentRepository` to find students based on different criteria such as name, last name, or ID.
  
- **Updating Student Information:** Update student information using methods provided by `StudentRepository`.
  
- **Filtering Students:** Use filtering methods in `StudentRepository` to retrieve students based on specific criteria.
  
- **Counting Students:** Get the total count of students using the `count()` method in `StudentRepository`.
  
- **Sorting Students:** Retrieve sorted lists of students by various attributes using sorting methods in `StudentRepository`.
  
- **Deleting Students:** Remove student records from the database using deletion methods provided by `StudentRepository`.

#### Testing:
The project includes test cases to ensure the correctness and functionality of implemented methods and operations. Tests cover various scenarios such as adding, finding, updating, filtering, sorting, and deleting student records.

#### Technologies Used:
- Java Persistence API (JPA)
- Java Persistence Query Language (JPQL)
- Java Programming Language

This project serves as a practical example of using JPA and JPQL for managing and manipulating data in a Java application. It demonstrates basic database operations and provides a foundation for building more complex data management and persistence systems.
