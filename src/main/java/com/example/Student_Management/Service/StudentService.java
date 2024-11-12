package com.example.Student_Management.Service;

import com.example.Student_Management.Exception.StudentNotFoundException;
import com.example.Student_Management.Repository.StudentRepository;
import com.example.Student_Management.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Transactional
    public Student updateStudent(int id, Student updatedStudent) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        updatedStudent.setStudentId(id);
        return studentRepository.save(updatedStudent);
    }

    @Transactional
    public void deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
