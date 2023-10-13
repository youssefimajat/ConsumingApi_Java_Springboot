package practice.consumingrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.consumingrestapi.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping(value = "/getStudent")
    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(1,"Mohamed","Mohamed@Mohamed.com");
        students.add(s1);
        Student s2 = new Student(2,"Reda","Reda@Reda.com");
        students.add(s2);
        Student s3 = new Student(3,"Abdelaziz","Abdelaziz@Abdelaziz.com");
        students.add(s3);
        return students;
    }
}
