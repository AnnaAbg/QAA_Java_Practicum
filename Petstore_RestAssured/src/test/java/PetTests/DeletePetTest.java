package PetTests;

import base.BaseTest;
import dto.response.ErrorResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_ERROR_404;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedErrorObjectBuilder.getNonExistingPetID;
import static utils.testDataHelper.TestDataPetHelper.VALID_RANDOM_PET_ID;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

/**
 * This class contains tests for deleting a pet from the store.
 */

@Epic("Delete Pet From the Store")
@Feature("Delete Pet")

public class DeletePetTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete existing pet and check by ID")
    @Description("Check handling existing pet ID during deletion.")
    @Test
    public void getDeleteExistingPet() {

        step("Create pet model request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID));
        });

        step("Delete request with /pet/:petId path", () -> {
            responseWrapper = petApiRequests.deletePet(VALID_RANDOM_PET_ID);
            assertThat(responseWrapper.getStatusCode())
                    .withFailMessage("Failed to delete the pet")
                    .isEqualTo(STATUS_CODE_OK);
        });


        step("Get request with /pet/:petId path", () -> {
            responseWrapper = petApiRequests.getPetByID(VALID_RANDOM_PET_ID);
        });

        step("Check status code and response", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getNonExistingPetID());
                    }
            );
        });

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete non- existing pet from the store")
    @Description("Check deleting an non- existing pet from the store.")
    @Test
    public void testDeleteNonExistingPet() {

        step("Create pet model request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID));
        });

        step("Delete request with /pet/:petId path", () -> {
            responseWrapper = petApiRequests.deletePet(VALID_RANDOM_PET_ID);
//            assertThat(responseWrapper.getStatusCode())
//                    .withFailMessage("Failed to delete the pet")
//                    .isEqualTo(STATUS_CODE_OK);
        });

        step("Delete request with /pet/:petId path", () -> {
            responseWrapper = petApiRequests.deletePet(VALID_RANDOM_PET_ID);
        });


        step("Check response / status code", () -> {
            int statusCode = responseWrapper.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                    }
            );
        });
    }
}
