package com.example.spring_kadai_todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_kadai_todo.entity.ToDo;
import com.example.spring_kadai_todo.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private final ToDoRepository toDoRepository;
	
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository = toDoRepository;
	}
	
	public List<ToDo> getAllToDos() {
		return toDoRepository.findAll();
	}
}