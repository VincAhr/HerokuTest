package de.neuefische.herokutest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsServiceTest {


    @Test
    void shouldCreateNewJoke(){
        // Given
        Question questiontocreate = new Question();
        questiontocreate.setQuestion("Bringt ein mockingtest spaß");

        Question savedquestion = new Question();
        savedquestion.setId("1212");
        savedquestion.setQuestion("Bringt ein mockingtest spaß?");

        QuestionsRepository questionsRepository = mock(QuestionsRepository.class);
        Mockito.when(questionsRepository.save(questiontocreate)).thenReturn(savedquestion);

        QuestionsService jokeService = new QuestionsService(questionsRepository);

        // When
        Question result = jokeService.createQuestion(questiontocreate);

        // Then
        Assertions.assertThat(result).isSameAs(savedquestion);

    }


}