package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.events.TestEvent;
import com.zetta.springexperiments.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rabbit")
public class EventController {
    @Autowired
    private EventService eventService;
    private static int counter = 1;

    @GetMapping()
    public void postMessage(@RequestParam(required = true) String message) throws InterruptedException {
        eventService.sendMessage(new TestEvent(counter,message));
        counter++;
    }
}
