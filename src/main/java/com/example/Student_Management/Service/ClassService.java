//package com.example.Student_Management.Service;
//
//import com.example.Student_Management.Repository.ClassRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ClassService {
//
//    @Autowired
//    private ClassRepository classRepository;
//
//    public Class createClass(Class classEntity){
//        return classRepository.save(classEntity);
//    }
//
//    public List<Class> getAllClasses(){
//        return classRepository.findAll();
//    }
//
//    public Class getClassById(int id) throws ClassNotFoundException {
//        Optional<Class> classEntity = classRepository.findById(id);
//        return classEntity.orElseThrow(() -> new ClassNotFoundException("Class with ID " + id + " not found"));
//    }
//
//    public Class updateClass(int id, Class updatedClass) throws ClassNotFoundException {
//        if(!classRepository.existsById(id)){
//            throw new ClassNotFoundException("Class with ID " + id + " not found");
//        }
//        updatedClass.setStudentId(id);
//        return classRepository.save(updatedClass);
//    }
//
//}
