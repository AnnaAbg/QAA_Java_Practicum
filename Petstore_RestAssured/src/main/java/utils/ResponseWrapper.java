package utils;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Wrapper class for API response handling.
 *
 * <p>This class provides methods to retrieve response data and handle responses in various formats.</p>
 */
@AllArgsConstructor
public class ResponseWrapper {

    /**
     * The underlying response object.
     */
    private final Response response;

    /**
     * Converts the response to the specified class type.
     *
     * @param "clazz" </clazz> the class type to which the response should be converted
     * @param <T>     the type of the response
     * @return the response object converted to the specified class type
     */

    public <T> T as(Class<T> Clazz) {
        return response.as(Clazz);
    }

    /**
     * Converts the response to a list of the specified class type.
     *
     * @param "clazz" the class type to which the response should be converted
     * @param <T>     the type of the response
     * @return a list containing the response object converted to the specified class type
     */
    public <T> List<T> asList(Class<T[]> Clazz) {
        return List.of(response.as(Clazz));
    }

    /**
     * Retrieves the status code of the response.
     *
     * @return the status code of the response
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }
}
