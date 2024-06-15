package config;

import org.aeonbits.owner.Config;

/**
 * Base configuration interface for accessing configuration properties.
 *
 * @Config.Sources({"classpath:config.properties"})
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    /**
     * Retrieves the base URL from the configuration properties.
     */

    String baseUrl();
}
