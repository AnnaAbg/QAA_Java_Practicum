package utils.testDataHelper;

import utils.RandomDataHelper;

/**
 * Helper class providing test data constants related to store orders for API testing.
 *
 * <p>This class contains constants for various store order attributes such as IDs,
 * pet IDs, quantities, ship dates, statuses, and flags indicating completion.
 * It also includes constants for invalid date formats, invalid order IDs, and an empty order ID.</p>
 */
public class TestDataStoreHelper {

    public static final String VALID_RANDOM_STORE_ID = String.valueOf(RandomDataHelper.getRandomNUmber());
    public static final int PET_ID = 0;
    public static final int QUANTITY = 0;
    public static final String SHIP_DATE = "2024-06-07T14:00:46.050Z";
    public static String STATUS = "placed";
    public static final boolean COMPLETE = true;

    public static final String INVALID_DATE_FORMAT_SHIP_DATE = "09/06/2024";
    public static final String INVALID_ORDER_ID = "knnkki";
    public static final String EMPTY_ORDER_ID = "";
}
