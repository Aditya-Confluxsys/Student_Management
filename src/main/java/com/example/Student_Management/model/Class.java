package com.example.Student_Management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int class_id;

    @Column(name = "class_name")
    private String class_name;

    @Column(name = "class_teacher")
    private String class_teacher;

    @Column(name = "room_number")
    private int room_number;

    public int getClass_id(){
        return class_id;
    }
    public void  setClass_id(int class_id){
        this.class_id = class_id;
    }

    public String getClass_name(){
        return class_name;
    }
    public void setClass_name(String class_name){
        this.class_name = class_name;
    }

    public String getClass_teacher(){
        return class_teacher;
    }
    public void setClass_teacher(String class_teacher){
        this.class_teacher = class_teacher;
    }

    public int getRoom_number(){
        return room_number;
    }
    public void setRoom_number(int room_number){
        this.room_number = room_number;
    }
}
