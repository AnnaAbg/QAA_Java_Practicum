package config;

import org.aeonbits.owner.Config;

/**
 * BaseConfig interface is used to load configuration properties from a file.
 * <p>
 * The properties file is expected to be found in the classpath with the name "config.properties".
 * This interface provides methods to retrieve values for baseUrl, driverPath, and driverProperty
 * from the properties file.
 * </p>
 *
 * @Config.Sources specifies the location of the properties file.
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    String baseUrl();
    String driverPath();
    String driverProperty();
}
