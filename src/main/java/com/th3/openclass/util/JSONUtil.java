package com.th3.openclass.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public interface JSONUtil {
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    static String toJSON(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
