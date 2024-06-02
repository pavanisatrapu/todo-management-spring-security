package com.todo_management.todo_management.service;

import com.todo_management.todo_management.dto.TodoDto;
import com.todo_management.todo_management.entity.Todo;
import com.todo_management.todo_management.exceptions.ResourceNotFoundException;
import com.todo_management.todo_management.mapper.TodoMapper;
import com.todo_management.todo_management.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo= todoRepository.save(TodoMapper.todoMapper.toTodo(todoDto));
        return TodoMapper.todoMapper.toTodoDto(todo);
    }

    @Override
    public TodoDto getTodoById(Long id) {
        Todo todo=todoRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("todo with id "+id+" not found"));
        return TodoMapper.todoMapper.toTodoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoDto> todoDtoList=new ArrayList<>();
        List<Todo> todoList=todoRepository.findAll();
        for (int i=0;i<todoList.size();i++){
            todoDtoList.add(TodoMapper.todoMapper.toTodoDto(todoList.get(i)));
        }
        return todoDtoList;
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto) {
        Todo todo=todoRepository.findById(todoDto.getTodoId()).get();
        todo.setTodoDescription(todoDto.getTodoDescription());
        todo.setTodoTitle(todoDto.getTodoTitle());
        todo.setTodoProgress(todoDto.getTodoProgress());
        Todo updatedTodo=todoRepository.save(todo);
        return TodoMapper.todoMapper.toTodoDto(updatedTodo);
    }

    @Override
    public TodoDto deleteTodo(Long id) {
        Todo todo=todoRepository.findById(id).get();
        todoRepository.delete(todo);
        return TodoMapper.todoMapper.toTodoDto(todo);
    }

    @Override
    public TodoDto updateProgress(Long id, String progress) {
        Todo todo=todoRepository.findById(id).get();
        todo.setTodoProgress(progress);
        Todo savedTodo=todoRepository.save(todo);
        //System.out.println(savedTodo);
        return TodoMapper.todoMapper.toTodoDto(savedTodo);
    }
}
