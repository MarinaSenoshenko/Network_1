package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import context.Context;

public class NetworkParser {
    private static final String IP_GROUP = "ip_group";
    private static final String PORT = "port";
    private static final String NOTIFY_PERIOD = "notify_period";

    private Properties loadProperties(String file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return null;
    }

    public Context getNetworkContext(String file) {
        Properties properties = loadProperties(file);
        return new Context(properties.getProperty(IP_GROUP), 
        		Integer.parseInt(properties.getProperty(PORT)), 
        		Integer.parseInt(properties.getProperty(NOTIFY_PERIOD)));
    }
}

