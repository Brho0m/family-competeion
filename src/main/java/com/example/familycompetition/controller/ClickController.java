package com.example.familycompetition.controller;

import com.example.familycompetition.ClickDTO;
import com.example.familycompetition.model.Click;
import com.example.familycompetition.repository.ClickRepository;
import com.example.familycompetition.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clicks")
public class ClickController {
    @Autowired
    private ClickService clickService;

    @Autowired
    private ClickRepository clickRepository;

    @PostMapping
    public void recordClick(@RequestBody Long userId) {
        clickService.recordClick(userId);
    }

    @GetMapping
    public List<ClickDTO> getAllClicksOrdered() {
        return clickRepository.findAllByOrderByTimeClickedAsc()
                .stream()
                .map(click -> new ClickDTO(click.getId(), click.getUser().getUsername(), click.getUser().getId(), click.getTimeClicked()))
                .collect(Collectors.toList());
    }

    @PostMapping("/reset")
    public void resetClicks() {
        clickService.resetClicks();
    }
}
