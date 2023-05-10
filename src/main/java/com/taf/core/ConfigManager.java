package com.taf.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taf.business.exceptions.ProcessingException;
import com.taf.core.dto.ConfigDTO;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static final String CONFIG_PROPERTIES_FILE = "src/test/resources/config.properties";
    private static ConfigDTO configDTO = null;

    private ConfigManager() {
        loadConfiguration();
    }

    private static ConfigDTO getConfig() {
        if (configDTO == null) {
            configDTO = loadConfiguration();
        }
        return configDTO;
    }

    public static String getLogin() { return getConfig().getLogin(); }
    public static String getPassword() {
        return getConfig().getPassword();
    }

    private static ConfigDTO loadConfiguration() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(fileInputStream);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(prop, ConfigDTO.class);
        } catch (Exception e) {
            throw new ProcessingException("Failed to load config file", e);
        }
    }
}
