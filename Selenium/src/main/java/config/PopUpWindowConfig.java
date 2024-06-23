package config;

import org.aeonbits.owner.Config;

/**
 * PopUpWindowConfig interface is used to load configuration properties related to popup window from a file.
 * <p>
 * The properties file is expected to be found in the classpath with the name "popup_window_config.properties".
 * This interface provides methods to retrieve values for cookie name, cookie value, session key, session value,
 * local storage key, and local storage value from the properties file.
 * </p>
 *
 * @Config.Sources specifies the location of the properties file.
 */
@Config.Sources({"classpath:popup_window_config.properties"})
public interface PopUpWindowConfig extends Config {

    @Key("cookieName")
    String cookieName();

    @Key("cookieValue")
    String cookieValue();

    @Key("sessionKey")
    String sessionKey();

    @Key("sessionValue")
    String sessionValue();

    @Key("localStorageKey")
    String localStorageKey();

    @Key("localStorageValue")
    String localStorageValue();
}
