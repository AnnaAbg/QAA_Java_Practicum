package utils.testObjectBuilder;

import dto.data.PetStoreModel;
import static utils.RandomDataHelper.getRandomNUmber;
import static utils.testDataHelper.TestDataStoreHelper.*;

/**
 * Utility class to build test instances of {@link PetStoreModel} for API testing.
 *
 * <p>This class provides static methods to generate {@code PetStoreModel} instances for different scenarios,
 * such as creating a new pet store model with complete information and
 * creating a new pet store model with a specified ship date.</p>

 */
public class TestPetStoreBuilder {

    /**
     * Builds a {@code PetStoreModel} instance with complete information.
     *
     * @param id the ID of the pet store
     * @return a {@link PetStoreModel} instance
     */
    public static PetStoreModel getPetStoreModel(String id) {
        return PetStoreModel.builder()
                .id(id)
                .petId(getRandomNUmber())
                .quantity(getRandomNUmber())
                .shipDate(SHIP_DATE)
                .status(STATUS)
                .complete(COMPLETE)
                .build();
    }

    public static PetStoreModel getPetStoreModel(String id, String shipDate) {
        return PetStoreModel.builder()
                .id(id)
                .petId(getRandomNUmber())
                .quantity(getRandomNUmber())
                .shipDate(shipDate)
                .status("placed")
                .complete(true)
                .build();
    }
}


