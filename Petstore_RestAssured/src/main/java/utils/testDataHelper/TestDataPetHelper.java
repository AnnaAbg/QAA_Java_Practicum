package utils.testDataHelper;

import utils.RandomDataHelper;

import java.util.List;


/**
 * Helper class providing test data constants related to pet attributes for API testing.
 *
 * <p>This class contains constants for various pet-related attributes such as IDs, names, categories, tags, and statuses.
 * It also provides a list of photo URLs for scenarios where photo URLs are not found.</p>
 *
 */
public class TestDataPetHelper {

    /**
     * Pet ID generated for testing.
     */
    public static final String VALID_RANDOM_PET_ID = String.valueOf(RandomDataHelper.getRandomNUmber());
    public static final int VALID_INTEGER_RANDOM_PET_ID = RandomDataHelper.getRandomNUmber();

    public static final String NOT_VALID_PET_ID = "kbjbb";
    // "dfadff"

    public static final String VALID_PET_ID = "1804";


    /**
     * Placeholder for a pet ID when not found in test scenarios.
     */
    public static final String PET_ID_NOT_FOUND = "<long>";

    /**
     * Placeholder for a pet name when not found in test scenarios.
     */
    public static final String PET_NAME_NOT_FOUND = "<string>";

    /**
     * Placeholder for a category ID when not found in test scenarios.
     */
    public static final int VALID_CATEGORY_ID = 0;

    public static final int CATEGORY_ID_NOT_FOUND = 0;

    /**
     * Placeholder for a category name when not found in test scenarios.
     */
    public static final String CATEGORY_NAME_NOT_FOUND = "<string>";

    /**
     * Placeholder for a tag ID when not found in test scenarios.
     */

    public static final int VALID_TAG_ID = 0;
    public static final int TAG_ID_NOT_FOUND = 0;

    /**
     * Placeholder for a tag name when not found in test scenarios.
     */
    public static final String VALID_TAG_NAME = "tagOne";
    public static final String TAG_NAME_NOT_FOUND = "<string>";

    /**
     * Pet status
     */
    public static final String VALID_STATUS = "available";

    public static final String SOLD_STATUS = "sold";

    public static final String PENDING_STATUS = "pending";

    /**
     * A list of photo URLs used when photo URLs are not found in test scenarios.
     */
    private final List<String> PHOTO_URLS_NOT_FOUND = List.of("<string>");




}
