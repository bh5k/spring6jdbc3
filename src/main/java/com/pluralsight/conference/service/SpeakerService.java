package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();

    Speaker create(Speaker speaker);

    Speaker getSpeaker(int id);

    Speaker updateSpeaker(Speaker speaker);

    void batch();

    void delete(int id);
}
