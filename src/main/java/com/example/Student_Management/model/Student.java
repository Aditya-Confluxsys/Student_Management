package com.example.Student_Management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import java.io.IOException;

@Entity
@Table(name="Student_profile")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Class clazz;

//    @Column(name = "additional_info", columnDefinition = "jsonb")
//    private JsonNode additionalInfo;

    @Column(name = "additional_info")
    private String additional_info;

    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public Class getClazz(){
        return clazz;
    }
    public void setClazz(Class clazz){
        this.clazz = clazz;
    }

//    public JsonNode getAdditionalInfo(){
//        return additionalInfo;
//    }
//    public void setAdditionalInfo(JsonNode additionalInfo){
//        this.additionalInfo = additionalInfo;
//    }

    public JsonNode getAdditionalInfo(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readTree(this.additional_info);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void setAdditional_info(JsonNode additional_info) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            this.additional_info = mapper.writeValueAsString(additional_info);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
