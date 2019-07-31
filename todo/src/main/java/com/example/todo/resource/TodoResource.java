package com.example.todo.resource;

import com.example.todo.document.Todo;
import com.example.todo.repository.TodoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoResource {

    private TodoRepository todoRepository;

    public TodoResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/getTodos")
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @GetMapping("/getTodo/{id}")
    public Optional<Todo> getTodo(@PathVariable int id) {
        return todoRepository.findById(id);
    }

    @PostMapping("/addTodo")
    public String saveTodo(@RequestBody Todo todo){
        todoRepository.save(todo);
        return "Added Todo with id: " + todo.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);
        return "Todo " + id + " successfully deleted!";
    }
}