package com.example.spring_kadai_todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "title")
    private String title;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;
    
//    public Integer getId() {
//    	return Id;
//    }
//    
//    public String getTitle() {
//    	return title;
//    }
//    
//    public String getpriority() {
//    	return priority;
//    }
//    
//    public String getstatus() {
//    	return status;
//    }
}
