package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Speaker;
import com.pluralsight.conference.service.SpeakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpeakerController {

    private SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @PostMapping("speaker")
    public Speaker create(@RequestBody Speaker speaker){
        System.out.println("Name : " + speaker.getName());
        return speakerService.create(speaker);
    }

    @GetMapping("speakers")
    public List<Speaker> getSpeakers() {
        return speakerService.findAll();
    }


    @GetMapping("/speaker/{id}")
    public Speaker getSpeaker(@PathVariable("id") int id){
        return speakerService.getSpeaker(id);
    }
}
