package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;
import com.pluralsight.conference.repository.util.SpeakerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        List<Speaker> speakers = jdbcTemplate.query("select * from speakers", new SpeakerRowMapper());
        return speakers;
    }

    @Override
    public Speaker create(Speaker speaker) {
        jdbcTemplate.update("INSERT INTO speakers (name) values (?)", speaker.getName());
        return null;
    }

    @Override
    public Speaker getSpeaker(int id) {
        Speaker speaker = jdbcTemplate.queryForObject(
                    "select * from speakers where id = ?",
                    new SpeakerRowMapper(),
                    id
        );
        return speaker;
    }

    @Override
    public Speaker update(Speaker speaker) {
        jdbcTemplate.update(
                "update speakers set name = ? where id = ? ",
                speaker.getName() , speaker.getId());
        return speaker;
    }

    public void batchUpdate(List<Object[]> pairs) {
        jdbcTemplate.batchUpdate(
                "update speakers set skill = ? where id = ?", pairs);
    }
}
