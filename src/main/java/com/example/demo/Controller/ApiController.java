package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ApiController {

    private final List<String> tasks = new ArrayList<>();

    private final ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "tasks")
    public ResponseEntity<String> HelloWorld() {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping(path = "tasks")
    public ResponseEntity<Void> createTask(@RequestBody String task){
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "tasks")
    public ResponseEntity<Void> clearTasks() {
        tasks.clear();
        return ResponseEntity.ok().build();
    }

}
