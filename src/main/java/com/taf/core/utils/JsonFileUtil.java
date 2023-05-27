package com.taf.core.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class JsonFileUtil {
    @SneakyThrows
    public static String loadFileAsString(String resourcesFilePath, Map<String, String> replaceParams) {
        InputStream inputStream = JsonFileUtil.class.getClassLoader().getResourceAsStream(resourcesFilePath);
        if (inputStream != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            log.debug(jsonNode.toString());
            return applyReplaceParams(jsonNode.toString(), replaceParams);
        } else {
            log.warn("JSON file not found.");
            throw new RuntimeException("JSON file not found.");
        }
    }

    private static String applyReplaceParams(String fileContent, Map<String, String> replaceParams) {
        if (Objects.nonNull(replaceParams)) {
            for (Map.Entry<String, String> entry : replaceParams.entrySet()) {
                String placeholder = "{{%s}}".formatted(entry.getKey());
                String replacement = entry.getValue();
                fileContent = fileContent.replace(placeholder, replacement);
            }
        }
        return fileContent;
    }
}
