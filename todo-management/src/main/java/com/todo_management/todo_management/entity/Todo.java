package com.todo_management.todo_management.entity;


import jakarta.persistence.*;
import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
@Entity
@Data
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;

    @Column(name = "todo_title")
    private String todoTitle;

    @Column(name = "todo_description")
    private String todoDescription;

    @Column(name = "todo_progress")
    private String todoProgress;
}
