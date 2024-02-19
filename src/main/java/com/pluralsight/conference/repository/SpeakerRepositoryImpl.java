package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;
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

        // map result to object
        RowMapper<Speaker> speakerRowMapper = (rs, rowNum) -> {
            Speaker speaker = new Speaker();
            speaker.setId(rs.getInt("id"));
            speaker.setName(rs.getString("name"));
            return speaker;
        };


        List<Speaker> speakers = jdbcTemplate.query("select * from speakers", speakerRowMapper);
        return speakers;
    }

    @Override
    public Speaker create(Speaker speaker) {
        jdbcTemplate.update("INSERT INTO speakers (name) values (?)", speaker.getName());
        return null;
    }
}
