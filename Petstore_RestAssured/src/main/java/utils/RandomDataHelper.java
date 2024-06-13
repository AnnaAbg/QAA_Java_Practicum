package utils;

import com.github.javafaker.Faker;

import java.util.Random;

/**
 * Utility class to generate random test data using the Faker library.
 *
 * <p>This class provides static methods to generate random pet names, category names, URLs,
 * and status strings for API testing.</p>
 */
public class RandomDataHelper {


    /**
     * A Faker instance to generate random data.
     */
    private static final Faker faker = new Faker();


    private static final String REGEXP_PHOTO_URL = "http:\\\\[a-z]{5}";

    private static final String REGEXP_NOT_VALID_STATUS = "[a-z]{20}";


    public static String getRandomPetName() {
        return faker.dog().name();
    }


    public static String getRandomCategoryName() {
        return faker.dog().breed();
    }


    public static String getRandomUrl() {
        return faker.regexify(REGEXP_PHOTO_URL);
    }

    public static String getRandomNotValidStatus() {
        return faker.regexify(REGEXP_NOT_VALID_STATUS);
    }

    public static int getRandomNUmber() {
        return faker.number().randomDigit();
    }


//    public static Integer getRandomNumber() {
//        Random random = new Random();
//        return random.nextInt();
//    }
}
