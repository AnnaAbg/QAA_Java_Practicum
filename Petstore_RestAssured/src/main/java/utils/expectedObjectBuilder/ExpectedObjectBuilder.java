package utils.expectedObjectBuilder;

import dto.response.APIResponse;

import static utils.testDataHelper.TestDataStoreHelper.VALID_RANDOM_STORE_ID;

/**
 * Utility class to build predefined {@link APIResponse} objects for various success scenarios.
 *
 * <p>This class provides static methods to generate different success responses,
 * such as for image upload and deletion operations.</p>
 *
 */
public class ExpectedObjectBuilder {


    private static final int CODE = 200;

    private static final String TYPE = "unknown";

    private static final String MESSAGE = "additionalMetadata: null\nFile uploaded to ./white-siberian-husky-puppy-on-green-grass-field-3812207 (1).jpg, 454696 bytes";

    private static final String RANDOM_MESSAGE_ID = VALID_RANDOM_STORE_ID;


    /**
     * Returns an {@code APIResponse} object representing a successful image upload response.
     *
     * @return an {@link APIResponse} with code 200, type "unknown", and a message indicating the file upload details
     */
    public static APIResponse getUploadImageResponse(){
        return APIResponse.builder()
                .code(CODE)
                .type(TYPE)
                .message(MESSAGE)
                .build();
    }

    /**
     * Returns an {@code APIResponse} object representing a successful delete operation response.
     *
     * @return an {@link APIResponse} with code 200, type "unknown", and a message containing a random message ID
     */
    public static APIResponse getDeleteResponse(){
        return APIResponse.builder()
                .code(CODE)
                .type(TYPE)
                .message(RANDOM_MESSAGE_ID)
                .build();
    }
}
