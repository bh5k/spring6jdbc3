package com.pluralsight.conference.repository;

import com.pluralsight.conference.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
