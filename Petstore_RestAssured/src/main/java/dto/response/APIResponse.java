package dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a generic API response with a status code, type, and message.
 *
 * <p>This class is annotated with Lombok annotations to generate boilerplate code for
 * data manipulation and building.</p>
 */
@Data
@Builder
public class APIResponse {
    private final int code;
    private final String type;
    private final String message;
}