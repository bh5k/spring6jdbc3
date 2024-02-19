package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
public class SpeakerRepositoryImpl implements SpeakerRepository {

    private JdbcTemplate jdbcTemplate;

    public SpeakerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Speaker> findAll() {
        Speaker speaker = new Speaker();
        speaker.setName("Bryan Hansen");
        speaker.setSkill("Java");
        List<Speaker> speakers = new ArrayList<>();
        speakers.add(speaker);
        return speakers;
    }

    @Override
    public Speaker create(Speaker speaker) {
        jdbcTemplate.update("INSERT INTO speakers (name) values (?)", speaker.getName());
        return null;
    }
}
