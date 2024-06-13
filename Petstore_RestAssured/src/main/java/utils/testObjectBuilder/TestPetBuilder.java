package utils.testObjectBuilder;

import dto.data.PetModel;

import java.util.List;

import static utils.RandomDataHelper.*;
import static utils.testDataHelper.TestDataPetHelper.*;

/**
 * Utility class to build test instances of {@link PetModel} for API testing.
 *
 * <p>This class provides static methods to generate {@code PetModel} instances for different scenarios,
 * such as adding a new pet with complete information,
 * adding a new pet with specified status,
 * and adding an empty pet with default values.</p>
 *
 */
public class TestPetBuilder {

    /**
     * Builds a {@code PetModel} instance for adding a new pet with complete information.
     *
     * @param id the ID of the pet
     * @return a {@link PetModel} instance
     */
    public static PetModel getAddNewPetModel(String id) {
        return PetModel.builder()
                .id(id)
                .category(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_CATEGORY_ID)
                        .name(getRandomCategoryName())
                        .build())
                .name(getRandomPetName())
                .photoUrls(List.of(getRandomUrl()))
                .tags(List.of(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_TAG_ID)
                        .name(VALID_TAG_NAME)
                        .build()))
                .status(VALID_STATUS)
                .build();
    }

    /**
     * Builds a {@code PetModel} instance for adding a new pet with specified status.
     *
     * @param id     the ID of the pet
     * @param status the status of the pet
     * @return a {@link PetModel} instance
     */
    public static PetModel getAddNewPetModel(String id, String status) {
        return PetModel.builder()
                .id(id)
                .category(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_CATEGORY_ID)
                        .name(getRandomCategoryName())
                        .build())
                .name(getRandomPetName())
                .photoUrls(List.of(getRandomUrl()))
                .tags(List.of(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_TAG_ID)
                        .name(VALID_TAG_NAME)
                        .build()))
                .status(status)
                .build();
    }

    /**
     * Builds a {@code PetModel} instance for adding an empty pet with default values.
     *
     * @param status the status of the pet
     * @return a {@link PetModel} instance
     */
    public static PetModel getAddEmptyPetModel(String status) {
        return PetModel.builder()
                .id(PET_ID_NOT_FOUND)
                .category(PetModel.CategoryAndTagsItem.builder()
                        .id(CATEGORY_ID_NOT_FOUND)
                        .name(CATEGORY_NAME_NOT_FOUND)
                        .build())
                .name(PET_NAME_NOT_FOUND)
                .photoUrls(List.of(getRandomUrl()))
                .tags(List.of(PetModel.CategoryAndTagsItem.builder()
                        .id(TAG_ID_NOT_FOUND)
                        .name(TAG_NAME_NOT_FOUND)
                        .build()))
                .status(status)
                .build();
    }
}