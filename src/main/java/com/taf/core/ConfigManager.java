package com.taf.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taf.business.exceptions.ProcessingException;
import com.taf.core.dto.User;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static final String CONFIG_PROPERTIES_FILE = "src/test/resources/config.properties";
    private static ConfigManager instance;
    private User user = null;

    private ConfigManager() {
        loadConfiguration();
    }

    public static ConfigManager getConfig() {
        if (instance == null) {
            instance = new ConfigManager();
            instance.loadConfiguration();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    private void loadConfiguration() {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(fileInputStream);
            this.user = buildUserObject(prop);
        } catch (Exception e) {
            throw new ProcessingException("Failed to load config file", e);
        }
    }

    private User buildUserObject(Properties prop) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(prop, User.class);
    }
}
