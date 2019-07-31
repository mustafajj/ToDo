package com.example.todo.repository;

import com.example.todo.document.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, Integer> {

}