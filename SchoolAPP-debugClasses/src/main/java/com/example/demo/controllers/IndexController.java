package com.example.demo.controllers;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.domain.StudentDAO;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/main/")
public class IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/index ", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String viewHome(Model model) {
        List<Course> listcourse = courseService.listAll();
        model.addAttribute("listcourse", listcourse);
        System.out.println("Get / ");
        return "course";
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String viewStudentPage(Model model) {
        List<StudentDAO> li = new ArrayList<>();
        for(Object[] o : studentRepository.findStudent()){
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.setId(Long.parseLong(String.valueOf(o[0])));
            studentDAO.setStudentName((String) o[1]);
            studentDAO.setCourseName((String) o[2]);
            li.add(studentDAO);

        }
        model.addAttribute("liststudent", li);
        return "student";
    }
}
