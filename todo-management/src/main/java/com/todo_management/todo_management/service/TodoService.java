package com.todo_management.todo_management.service;

import com.todo_management.todo_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodoById(Long id);
    List<TodoDto> getAllTodos();
    TodoDto updateTodo(TodoDto todoDto);
    TodoDto deleteTodo(Long id);
    TodoDto updateProgress(Long id,String progress);
}
