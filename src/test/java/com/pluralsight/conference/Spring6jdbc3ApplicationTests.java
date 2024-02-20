package com.pluralsight.conference;

import com.pluralsight.conference.model.Speaker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Spring6jdbc3ApplicationTests {

    @Test
    public void testCreateSpeaker(){
        RestTemplate restTemplate = new RestTemplate();
        Speaker speaker = new Speaker();
        speaker.setName("Obida");

        speaker = restTemplate.postForObject("http://localhost:8080/speaker", speaker, Speaker.class);

        System.out.println(speaker.getName());
    }
    @Test
    void testGetSpeakers() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Speaker>> speakersResponse = restTemplate.exchange(
                "http://localhost:8080/speakers", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Speaker>>() {
                });

        assertTrue(speakersResponse.getBody() != null, "Body is null");

        List<Speaker> speakers = speakersResponse.getBody();

        for (Speaker speaker : speakers) {
            System.out.println("Speaker name: " + speaker.getName() + " " + speaker.getSkill());
        }
    }

    @Test
    void testGetSpeaker(){
        RestTemplate restTemplate = new RestTemplate();
        Speaker speaker = restTemplate.getForObject("http://localhost:8080/speaker/{id}", Speaker.class, 56);

        System.out.println("Name : " + speaker.getName());
    }

    @Test
    public void  testUpdateSpeaker(){
        RestTemplate restTemplate = new RestTemplate();
        Speaker speaker = restTemplate.getForObject("http://localhost:8080/speaker/{id}", Speaker.class, 56);

        speaker.setName(speaker.getName() + " Jr.");

        restTemplate.put("http://localhost:8080/speaker", speaker);

        System.out.println("Name: " + speaker.getName());
    }

    @Test
    public void testBatchUpdate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8080/speaker/batch", Object.class);
    }
}
