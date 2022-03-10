package de.neuefische.herokutest;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionsRepository questionsRepository;

    public Question createQuestion(Question question) {
        return questionsRepository.save(question);
    }

    public Optional<Question> findById(String id) {
        return questionsRepository.findById(id);
    }
    public List<Question> getall(){
        return questionsRepository.findAll();
    }

}
