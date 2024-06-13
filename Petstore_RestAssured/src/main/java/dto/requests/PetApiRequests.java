package dto.requests;

import dto.data.PetModel;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import java.io.File;

import static io.restassured.RestAssured.given;
import static utils.testDataHelper.TestDataPetHelper.*;

/**
 * Provides methods to perform API requests related to pets, including creating, updating, retrieving, and deleting pets,
 * as well as uploading pet images.
 */
public class PetApiRequests {

    private final RequestSpecification requestSpecification;

    private static String PET_PATH = "pet";
    private static final String FIND_BY_STATUS_PATH = "pet/findByStatus";
    private static final String ID_PARAMETER = "id";
    private static final String STATUS_PARAMETER = "status";
    private static final String API_KEY = "special-key";

    /**
     * Constructs a new {@code PetApiRequests} with the specified request specification.
     *
     * @param requestSpecification the request specification to configure the API requests
     */
    public PetApiRequests(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Creates a new pet with the specified details.
     *
     * @param request the details of the pet to create
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper createNewPet(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post(PET_PATH)
                .andReturn());
    }

    /**
     * Updates an existing pet with the specified details.
     *
     * @param request the details of the pet to update
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper updatePet(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .put(PET_PATH)
                .andReturn());
    }

    /**
     * Retrieves pets by their status.
     *
     * @param status the status of the pets to retrieve (e.g., available, pending, sold)
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper getPetByStatus(String status) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .param(STATUS_PARAMETER, status)
                .get(FIND_BY_STATUS_PATH)
                .andReturn());
    }

    /**
     * Retrieves a pet by its ID.
     *
     * @param id the ID of the pet to retrieve
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper getPetByID(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .param(ID_PARAMETER, id)
                .get(PET_PATH + "/" + id)
                .andReturn());
    }

    /**
     * Deletes a pet by its ID.
     *
     * @param id the ID of the pet to delete
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper deletePet(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .header("api-key", API_KEY)
                .when()
                //.param(ID_PARAMETER, id)
                .delete(PET_PATH + "/" + id)
                .andReturn());

    }

    /**
     * Uploads an image for a pet.
     *
     * @param petId              the ID of the pet to upload the image for
     * @param additionalMetadata additional metadata for the image upload
     * @param imageFile          the image file to upload
     * @return the response wrapped in a {@link ResponseWrapper}
     */
    public ResponseWrapper uploadImage(String petId, String additionalMetadata, File imageFile) {
        return new ResponseWrapper(given(requestSpecification)
                .contentType("multipart/form-data")
                .multiPart("file", imageFile, "image/jpg")
                .param("petId", petId)
                .param("additionalMetadata", additionalMetadata)
                .expect()
                .when()
                .post(petId + "/uploadImage")
                .andReturn());
    }
}

