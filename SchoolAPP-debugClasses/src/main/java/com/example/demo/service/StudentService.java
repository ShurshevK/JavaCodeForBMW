package com.example.demo.service;



import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final UserRepository userRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, UserRepository userRepository){
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }




    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Optional<Student> findStudentById(Long studentId){
        return studentRepository.findById(studentId);
    }

    public void addStudentAfterSingUp(Student student){
        List<Student> moveStudent = userRepository.moveStudent(student.getStudentId());
        studentRepository.save(student);
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository
                .findStudentByPhoneNumber(student.getPhoneNumber());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("phone number is taken");
        }
        studentRepository.save(student);

    }
    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with appUserId" + studentId
                    + "does not exists");
        }
        studentRepository.deleteById(studentId);


    }
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String phoneNumber){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with appUserId" + studentId
                        + "does not exists"));
        if (name!= null &&
        name.length() > 0 &&
        !Objects.equals (student.getStudentName(), name)) {
            student.setStudentName(name);
        }
        if (phoneNumber != null &&
                phoneNumber.length() > 0 &&
                !Objects.equals (student.getPhoneNumber(), phoneNumber)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByPhoneNumber(phoneNumber);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("phone taken");

            }
            student.setPhoneNumber(phoneNumber);
        }
    }
    public List<Student> listAll()
    {
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();
    }


    public void save(Student sdt) {
        studentRepository.save(sdt);
    }

    public Student get(long id) {
        return studentRepository.findById(id).get();
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }

}
