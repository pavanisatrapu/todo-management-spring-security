package com.todo_management.todo_management.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
@Data
public class TodoDto {

    private Long todoId;

    @NotEmpty(message = "todo title should not be empty")
    private  String todoTitle;

    @NotEmpty(message = "todo description should not be empty")
    private String todoDescription;

    @NotEmpty(message = "todo progress should not be empty")
    private String todoProgress;
}
