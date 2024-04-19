package com.minkyu.bus.presentation.dto;

import com.minkyu.bus.presentation.dto.ApiResponse.MsgBody.Item;

public record PositionResponse(String gpsX, String gpsY) {

    public static PositionResponse fromItem(Item item) {
        return new PositionResponse(item.gpsX(), item.gpsY());
    }
}
