package com.test.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Supplier;

public final class ConfigProvider {

    private static final ConfigProvider INSTANCE = new ConfigProvider();

    private Properties properties = new Properties();

    private ConfigProvider() {
        try {
            Properties fileProperties = extractPropertiesFromFile("application.properties");
            properties.putAll(fileProperties);
        } catch (final IllegalStateException e) {
            throw new IllegalStateException("Failed to load environment configuration file", e);
        }
    }

    public static ConfigProvider configuration() {
        return INSTANCE;
    }

    public String getStringProperty(final String propertyName) {
        return Optional.ofNullable(properties.getProperty(propertyName)).orElseThrow(throwArgumentException(propertyName));
    }

    private Properties extractPropertiesFromFile(String pathToPropertyFile) {
        final InputStream inputStream =
                Optional.ofNullable(ConfigProvider.class.getClassLoader().getResourceAsStream(pathToPropertyFile)).orElseThrow(() -> new IllegalStateException("Unable to load properties - file might not be specified: ".concat(pathToPropertyFile)));
        final Properties props = new Properties();
        try {
            props.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load properties from resource: ".concat(pathToPropertyFile));
        }
        return props;
    }

    private Supplier<IllegalArgumentException> throwArgumentException(final String propertyName) {
        return () -> new IllegalArgumentException(String.format("Property '%s' is not set", propertyName));
    }
}
