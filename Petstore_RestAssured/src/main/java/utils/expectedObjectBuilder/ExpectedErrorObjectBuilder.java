package utils.expectedObjectBuilder;

import dto.response.ErrorResponse;

import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;

/**
 * Utility class to build predefined {@link ErrorResponse} objects for various error scenarios.
 *
 * <p>This class provides static methods to generate different error responses, such as unknown errors,
 * non-existing pet ID errors, order not found errors, and number format exception errors.</p>
 *
 */
public class ExpectedErrorObjectBuilder {

    private static final int UNKNOWN_CODE = 500;

    private static final int NOT_FOUND_CODE = 404;

    private static final int ERROR_CODE = 1;

    private static final String UNKNOWN_TYPE = "unknown";

    private static final String ERROR_TYPE = "error";

    private static final String UNKNOWN_MESSAGE = "something bad happened";

    private static final String ERROR_MESSAGE = "Pet not found";

    private static final String ORDER_NOT_FOUND_MESSAGE  = "Order Not Found";

    private static final String NUMBER_FORMAT_EXCEPTION_ERROR_MESSAGE = "java.lang.NumberFormatException: For input string: " +  VALID_RANDOM_STORE_ID;

    /**
     * Returns an {@code ErrorResponse} object representing an unknown error.
     *
     * @return an {@link ErrorResponse} with code 500, type "unknown", and message "something bad happened"
     */
    public static ErrorResponse getUnknownErrorResponse(){
        return ErrorResponse.builder()
                .code(UNKNOWN_CODE)
                .type(UNKNOWN_TYPE)
                .message(UNKNOWN_MESSAGE)
                .build();
    }

    /**
     * Returns an {@code ErrorResponse} object representing an error for a non-existing pet ID.
     *
     * @return an {@link ErrorResponse} with code 1, type "error", and message "Pet not found"
     */
    public static ErrorResponse getNonExistingPetID(){
        return ErrorResponse.builder()
                .code(ERROR_CODE)
                .type(ERROR_TYPE)
                .message(ERROR_MESSAGE)
                .build();
    }

    /**
     * Returns an {@code ErrorResponse} object representing an order not found error.
     *
     * @return an {@link ErrorResponse} with code 404, type "error", and message "Order Not Found"
     */
    public static ErrorResponse getOrderNotFound(){
        return ErrorResponse.builder()
                .code(NOT_FOUND_CODE)
                .type(ERROR_TYPE)
                .message(ORDER_NOT_FOUND_MESSAGE)
                .build();
    }

    /**
     * Returns an {@code ErrorResponse} object representing a number format exception error.
     *
     * @return an {@link ErrorResponse} with code 404, type "error", and message "java.lang.NumberFormatException: For input string: VALID_RANDOM_STORE_ID"
     */
    public static ErrorResponse getNotFound(){
        return ErrorResponse.builder()
                .code(NOT_FOUND_CODE)
                .type(ERROR_TYPE)
                .message(NUMBER_FORMAT_EXCEPTION_ERROR_MESSAGE)
                .build();
    }
}
