package com.todo_management.todo_management.mapper;

import com.todo_management.todo_management.dto.TodoDto;
import com.todo_management.todo_management.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {
    TodoMapper todoMapper= Mappers.getMapper(TodoMapper.class);

    TodoDto toTodoDto(Todo todo);
    Todo toTodo(TodoDto todoDto);
}
