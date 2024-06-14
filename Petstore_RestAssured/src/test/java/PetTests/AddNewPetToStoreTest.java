package PetTests;

import base.BaseTest;
import dto.data.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.*;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_ERROR_500;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getUnknownErrorResponse;
import static utils.testDataHelper.TestDataPetHelper.*;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

/**
 * Test class for adding a new pet to the store.
 * This class contains tests for happy path and invalid pet ID scenarios.
 */

@Epic("Pet Store")
@Feature("Add New Pet")
public class AddNewPetToStoreTest extends BaseTest {

    private RequestSpecification requestSpecification;
    // ServicePetSteps servicePetSteps = new ServicePetSteps();

    @Severity(SeverityLevel.CRITICAL)
    @Story("Add new pet to store with a valid pet ID")
    @Description("Check adding a new pet to the store with a valid pet ID.")
    @Test
    public void testNewPetToStore_HappyPath() {


        step("Create new pet model with Valid Pet ID", () -> {
            petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID);
        });

        step("Post request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest);
        });

        step("Check response and petID", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(petRequest);
                        assertThat(response.getId())
                                .withFailMessage("ID doesn't match")
                                .isEqualTo(petRequest.getId());
                    }
            );
        });
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Add new pet to store with an invalid pet ID")
    @Description("Check adding a new pet to the store with an invalid pet ID.")
    @Test
    public void testAddPetToStoreWithInvalidPetID() {

        step("Create new pet model with Invalid Pet ID", () -> {
            petRequest = getAddNewPetModel(NOT_VALID_PET_ID);
        });

        step("Post request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest);
        });

        step("Check status code and error response", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });

    }
}

