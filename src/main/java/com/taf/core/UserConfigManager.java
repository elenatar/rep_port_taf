package com.taf.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taf.business.exceptions.ProcessingException;
import com.taf.core.models.Admin;
import com.taf.core.models.User;

import java.io.FileInputStream;
import java.util.Properties;

public class UserConfigManager {

    private static final String USERS_PROPERTIES = "src/test/resources/users.properties";
    private static UserConfigManager instance;
    private User user = null;
    private User admin = null;

    private UserConfigManager() {
        loadConfiguration();
    }

    public static UserConfigManager getUserConfig() {
        if (instance == null) {
            instance = new UserConfigManager();
            instance.loadConfiguration();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public User getAdmin() {
        return admin;
    }

    private void loadConfiguration() {
        try (FileInputStream fileInputStream = new FileInputStream(USERS_PROPERTIES)) {
            Properties prop = new Properties();
            prop.load(fileInputStream);
            this.user = buildUserObject(prop, User.class);
            this.admin = buildUserObject(prop, Admin.class);
        } catch (Exception e) {
            throw new ProcessingException("Failed to load config file", e);
        }
    }

    private User buildUserObject(Properties prop, Class<? extends User> userClass) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(prop, userClass);
    }
}
