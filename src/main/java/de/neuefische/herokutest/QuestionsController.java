package de.neuefische.herokutest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionsService questionservice;

    @PostMapping
    public Question createNewJoke(@RequestBody Question question) {
        return questionservice.createQuestion(question);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findJokeById(@PathVariable String id) {
        return ResponseEntity.of(questionservice.findById(id));
    }

    @GetMapping("/getall")
    public List<Question> getall () {
        return questionservice.getall();
    }
}
