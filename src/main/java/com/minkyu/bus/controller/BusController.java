package com.minkyu.bus.controller;

import com.google.gson.Gson;
import com.minkyu.bus.presentation.dto.PositionRequest;
import com.minkyu.bus.presentation.dto.PositionResponse;
import com.minkyu.bus.service.BusService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bus")
public class BusController {

    private final BusService busService;
    private final Gson gson;

    @GetMapping("")
    public String getPositionsByBusId(PositionRequest positionRequest, Model model) {

        List<PositionResponse> positions = busService.getBusPositions(positionRequest.busId());

        return gson.toJson(positions);
    }
}
