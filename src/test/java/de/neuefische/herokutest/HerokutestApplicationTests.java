package de.neuefische.herokutest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HerokutestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Question question = new Question();
        question.setQuestion("Was ist flap-doodle?");


        ResponseEntity<Question> postResponse = restTemplate.postForEntity("/api/questions", question, Question.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getId()).isNotNull();
        assertThat(postResponse.getBody().getQuestion()).isEqualTo("Was ist flap-doodle?");
    }

}
