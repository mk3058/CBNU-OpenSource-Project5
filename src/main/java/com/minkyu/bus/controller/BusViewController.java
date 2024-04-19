package com.minkyu.bus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bus")
public class BusViewController {

    @Value("${google.map.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);

        return "busMap";
    }


}

