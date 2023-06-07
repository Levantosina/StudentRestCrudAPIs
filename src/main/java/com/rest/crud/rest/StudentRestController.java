package com.rest.crud.rest;

import com.rest.crud.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Levantosina
 */

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> listStudents;
    //define @postCinstruct to load the student data

    @PostConstruct
    public void PostConstruct(){
        listStudents = new ArrayList<>();
        listStudents.add(new Student("Mary", "Jane"));
        listStudents.add(new Student("John", "Doe"));
        listStudents.add(new Student("Susan", "Smith"));
    }

    @GetMapping("/students")

    public List<Student> getStudents() {

        return listStudents;

    }

    //define endpoint or"/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //index into the list
        //check the studentId against list size

        if(studentId>=listStudents.size()||studentId<0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return listStudents.get(studentId);
    }




}
