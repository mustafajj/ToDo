package com.example.todo.config;

import com.example.todo.repository.TodoRepository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = TodoRepository.class)
@Configuration
public class MongoDBConfig {

}