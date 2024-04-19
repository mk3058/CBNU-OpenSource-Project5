package com.minkyu.bus.presentation.dto;

import java.util.List;

public record ApiResponse(ComMsgHeader comMsgHeader, MsgHeader msgHeader, MsgBody msgBody) {

    public record ComMsgHeader(
            String responseMsgID,
            String responseTime,
            String requestMsgID,
            String successYN,
            String returnCode,
            String errMsg) {
    }

    public record MsgHeader(String headerMsg, String headerCd, int itemCount) {
    }

    public record MsgBody(List<Item> itemList) {

        public record Item(
                String sectOrd,
                String fullSectDist,
                String sectDist,
                String rtDist,
                String stopFlag,
                String sectionId,
                String dataTm,
                String tmX,
                String tmY,
                String gpsX,
                String gpsY,
                String posX,
                String posY,
                String vehId,
                String plainNo,
                String busType,
                String lastStTm,
                String nextStTm,
                String nextStId,
                String lastStnId,
                String trnstnid,
                String isrunyn,
                String islastyn,
                String isFullFlag,
                String congetion) {
        }
    }
}
