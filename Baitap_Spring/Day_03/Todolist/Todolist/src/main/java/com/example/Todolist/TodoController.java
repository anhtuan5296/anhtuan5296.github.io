package com.example.Todolist;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private List<Todo> todos = new ArrayList<>();

    @GetMapping
    public List<Todo> getTodos(@RequestParam(value = "status", required = false) Boolean status) {
        if (status == null) {
            return todos;
        } else {
            return todos.stream()
                    .filter(todo -> todo.getStatus().equals(status))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo newTodo) {
        newTodo.setId(todos.size() + 1);
        todos.add(newTodo);
        return newTodo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodo) {
        Todo existingTodo = todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingTodo != null) {
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setStatus(updatedTodo.getStatus());
            return existingTodo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}
