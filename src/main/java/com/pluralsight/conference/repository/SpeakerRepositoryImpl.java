package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
public class SpeakerRepositoryImpl implements SpeakerRepository {

    public List<Speaker> findAll() {
        Speaker speaker = new Speaker();
        speaker.setName("Bryan Hansen");
        speaker.setSkill("Java");
        List<Speaker> speakers = new ArrayList<>();
        speakers.add(speaker);
        return speakers;
    }
}
