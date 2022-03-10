package de.neuefische.herokutest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface QuestionsRepository extends MongoRepository<Question, String> {

   List<Question> findAllByQuestionContains(String question);

}
