package com.example.familycompetition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.familycompetition.service.ClickService;
import com.example.familycompetition.model.Click;
import com.example.familycompetition.ClickDTO;  // Assuming you use a DTO to handle data transfer

@Controller
public class WebSocketController {

    @Autowired
    private ClickService clickService;

    // Endpoint to receive and broadcast click data
    @MessageMapping("/clickReceived")
    @SendTo("/topic/clickOrder")
    public ClickDTO handleAndBroadcastClick(ClickDTO clickDTO) {
        // Assuming recordAndFetchClick handles ClickDTO directly
        Click click = clickService.recordAndFetchClick(clickDTO.getUserId(), clickDTO.getTimeClicked());
        
        // Assuming ClickDTO includes all necessary data for the frontend
        return new ClickDTO(click.getId(), click.getUser().getUsername(), click.getUser().getId(), click.getTimeClicked());
    }}