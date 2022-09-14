package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.entity.Aircraft;
import com.zetta.springexperiments.repository.AircraftRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequiredArgsConstructor
public class PositionController {
    @NonNull
    private final AircraftRepository aircraftRepository;
    private WebClient webClient = WebClient.create();

    @GetMapping("/aircraft")
    public String getCurrentAircraftPositions(Model model) {
        aircraftRepository.deleteAll();

        webClient.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(p -> !p.getReg().isEmpty())
                .toStream()
                .forEach(p -> aircraftRepository.save(p));
        model.addAttribute("currentPositions", aircraftRepository.findAll());
        return "Positions";
    }
}
