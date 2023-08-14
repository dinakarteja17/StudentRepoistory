package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidApplicationException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class StudentSaveController {


    @Autowired
    private StudentDAO studentDAO;


    @PostMapping("/createstudent")
    public StudentObjects createstudent(@RequestBody StudentObjects studentObjects) throws InvalidApplicationException {
        StudentInformation ppl = new StudentInformation();
        if (studentObjects.getName() != null && !studentObjects.getName().isEmpty()) {
            ppl.setName(studentObjects.getName());
        } else {
            throw new InvalidApplicationException(studentObjects);
        }
        ppl.setStudentid(studentObjects.getStudentid());
        ppl.setGender(studentObjects.getGender());
        ppl.setMailid(studentObjects.getMailid());
        ppl.setQualification(studentObjects.getQualification());
        ppl.setStream(studentObjects.getStream());
        ppl.setPhoneno(studentObjects.getPhoneno());
        ppl.setCourseinterest(studentObjects.getCourseinterest());

        studentDAO.save(ppl);

        return studentObjects;
    }

    @GetMapping("/getstudents")
    public List<StudentInformation> getstudents() {
        List<StudentInformation> studentlist = studentDAO.findAll();

        return studentlist;
    }


    @GetMapping("/eachstudent/{studentid}")
    public StudentInformation getstudent(@PathVariable int studentid) {
        Optional<StudentInformation> find = studentDAO.findById(studentid);
        StudentInformation student = find.get();
        return student;
    }

    @PutMapping("/updatestudent/{studentid}")
    public StudentInformation updatestudent(@PathVariable int studentid, @RequestBody StudentObjects studentObjects) {
        Optional<StudentInformation> studentisfound = studentDAO.findById(studentid);

        if (studentisfound.isPresent()) {

            StudentInformation student = studentisfound.get();
            student.setName(studentObjects.getName());
            student.setName(studentObjects.getGender());
            student.setName(studentObjects.getMailid());
            student.setName(studentObjects.getQualification());
            student.setName(studentObjects.getStream());
            student.setName(studentObjects.getCourseinterest());

            //getting return type is string
            //  student.setName(studentObjects.getPhoneno());

            return studentDAO.save(student);

        } else {
            return null;
        }
    }

    @DeleteMapping("/deletestudent/{studentid}")
    public StudentInformation deletestudent(@PathVariable int studentid) {
        Optional<StudentInformation> find = studentDAO.findById(studentid);
        StudentInformation student = new StudentInformation();
        if (find.isPresent()) {

              studentDAO.deleteById(studentid);
        }
        return student;
    }
}


//    People p = new People();
//        p.setName("venkat");
//        p.setJob("developer");
//        return "people";
        //System.out.println(peopleObjects.getAddress());


