package com.minkyu.bus.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseUtil {

    public static Map<String, String> json(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap;
        Map<String, String> result = new HashMap<>();

        try {
            jsonMap = mapper.readValue(new File(filePath),
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file" + filePath + ": " + e.getMessage());
        }
        List<Map<String, String>> dataList = (List<Map<String, String>>) jsonMap.get("DATA");
        dataList.forEach(data -> result.put(data.get("route"), data.get("route_id")));
        return result;
    }
}
