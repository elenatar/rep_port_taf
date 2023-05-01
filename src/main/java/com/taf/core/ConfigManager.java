package com.taf.core;

import com.taf.core.dto.ConfigDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigManager {
    private static final String CONFIG_PROPERTIES_FILE = "src/main/resources/config.properties";
    private static ConfigManager instance = null;
    @Getter
    private ConfigDTO configDTO = null;

    private ConfigManager() {
        loadConfiguration();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadConfiguration() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(CONFIG_PROPERTIES_FILE);
            Properties prop = new Properties();
            prop.load(fileInputStream);

            this.configDTO = new ConfigDTO(prop.getProperty("url"), prop.getProperty("login"), prop.getProperty(
                    "password"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file");
        } finally {
            closeInputStream(fileInputStream);
        }
    }

    private void closeInputStream(FileInputStream fileInputStream) {
        try {
            if (fileInputStream != null) {
                fileInputStream.close();
            } else {
                log.warn("FileInputStream is null");
            }

        } catch (IOException e) {
            log.warn("Failed to close FileInputStream", e);
        }
    }
}
