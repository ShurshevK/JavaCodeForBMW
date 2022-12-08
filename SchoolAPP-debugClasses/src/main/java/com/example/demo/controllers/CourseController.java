package com.example.demo.controllers;

import java.util.List;

import com.example.demo.domain.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/main/Course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @GetMapping("/addcourse")
    public String add(Model model) {
        List<Course> listcourse = courseService.listAll();
        model.addAttribute("listcourse", listcourse);
        model.addAttribute("course", new Course());
        return "addcourse";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addcourse");
        Course course = courseService.get(id);
        mav.addObject("course", course);
        return mav;

    }

    @RequestMapping("/delete/{id}")
    public String deleteCoursePage(@PathVariable(name = "id") int id) {
        courseService.delete(id);
        return "redirect:/course";
    }
}