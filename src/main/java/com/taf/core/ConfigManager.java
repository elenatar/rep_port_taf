package com.taf.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taf.business.exceptions.ProcessingException;
import com.taf.core.dto.ConfigDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class ConfigManager {
    private static final String CONFIG_PROPERTIES_FILE = "src/test/resources/config.properties";
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

    public static String getUrl() {
        return getInstance().configDTO.getUrl();
    }

    public static String getLogin() {
        return getInstance().configDTO.getLogin();
    }

    public static String getPassword() {
        return getInstance().configDTO.getPassword();
    }

    private void loadConfiguration() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES_FILE)){
            Properties prop = new Properties();
            prop.load(fileInputStream);
            ObjectMapper mapper = new ObjectMapper();
            this.configDTO = mapper.convertValue(prop, ConfigDTO.class);
        } catch (Exception e) {
            throw new ProcessingException("Failed to load config file", e);
        }
    }
}
