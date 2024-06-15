package dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * Represents an error response from an API with a status code, type, and message.
 *
 * <p>This class is annotated with Lombok annotations to generate boilerplate code for
 * data manipulation and building.</p>
 */
@Data
@Builder
public class ErrorResponse {
    private final int code;
    private final String type;
    private final String message;
}