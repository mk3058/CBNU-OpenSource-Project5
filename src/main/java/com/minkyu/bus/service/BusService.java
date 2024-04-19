package com.minkyu.bus.service;

import com.minkyu.bus.common.ParseUtil;
import com.minkyu.bus.presentation.dto.ApiResponse;
import com.minkyu.bus.presentation.dto.PositionResponse;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusService {

    @Value("${bus.api.uri}")
    private String apiUrl;

    @Value("${bus.api.key}")
    private String apiKey;

    @Value("${json.route-info.path}")
    private String json_file_path;

    public List<PositionResponse> getBusPositions(String busId) {
        String routeId = getRouteIdByBusId(busId).orElseThrow(IllegalArgumentException::new);
        RestTemplate restTemplate = new RestTemplate();

        try {
            URI uri = new URI(String.format("%s?ServiceKey=%s&busRouteId=%s&resultType=json", apiUrl, apiKey, routeId));
            ApiResponse response = restTemplate.getForObject(uri, ApiResponse.class);
            return response.msgBody().itemList().stream()
                    .map(PositionResponse::fromItem)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot get api Response" + ": " + e.getMessage());
        }
    }

    private Optional<String> getRouteIdByBusId(String busId) {
        Map<String, String> routeIds = ParseUtil.json(json_file_path);
        return Optional.of(routeIds.get(busId));
    }
}