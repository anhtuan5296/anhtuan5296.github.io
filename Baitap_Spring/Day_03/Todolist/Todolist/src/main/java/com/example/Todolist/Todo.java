package com.example.Todolist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Todo {
    private Integer id;
    private String title;
    private Boolean status;

    public Todo(String title) {
        this.title = title;
        this.status = false;
    }
}
