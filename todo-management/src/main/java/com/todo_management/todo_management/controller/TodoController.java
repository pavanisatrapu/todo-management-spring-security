package com.todo_management.todo_management.controller;

import com.todo_management.todo_management.dto.TodoDto;
import com.todo_management.todo_management.service.TodoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/todo")
public class TodoController {
    private TodoServiceImpl todoServiceImpl;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("")
    public String welcome(){
        return "welcome to todo management system";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        return new ResponseEntity<>(todoServiceImpl.addTodo(todoDto),HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id){
        return new ResponseEntity<>(todoServiceImpl.getTodoById(id), HttpStatus.OK);
        //todoServiceImpl.getTodoById(id);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("all")
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        return new ResponseEntity<>(todoServiceImpl.getAllTodos(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public  ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto){
        return new ResponseEntity<>(todoServiceImpl.updateTodo(todoDto),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}/{progress}")
    public ResponseEntity<TodoDto> updateProgress(@PathVariable Long id, @PathVariable String progress){
        return new ResponseEntity<>(todoServiceImpl.updateProgress(id,progress),HttpStatus.OK);
    }


}
