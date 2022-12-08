package com.example.demo.controllers;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/api/main/Student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("addstudent")
    public String addStudent(Model model) {
        List<Student> liststudent = studentService.listAll();
        List<Course> listcourse = courseService.listAll();
        model.addAttribute("listcourse", listcourse);
        model.addAttribute("liststudent", liststudent);
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std)
    {
        studentService.save(std);
        return "redirect:/student";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/edit/{student_id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addstudent");
        List<Course> listcourse = courseService.listAll();
        Student std = studentService.get(id);
        mav.addObject("student", std);
        return mav;

    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{student_id}")
    public String deleteStudentPage(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "student";
    }




    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addStudentAfterSingUp(student);
    }

    @DeleteMapping(path = "{student_id}")
    public void deleteStudent(
            @PathVariable("student_id") Long studentId){
        studentService.deleteStudent(studentId);
    }


    @PutMapping(path = "{student_id}")
    public void updateStudent(
            @PathVariable("student_id") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);


    }


}
