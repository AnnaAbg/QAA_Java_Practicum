package PetTests;

import base.BaseTest;
import dto.data.PetModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.testDataHelper.TestDataPetHelper.VALID_RANDOM_PET_ID;
import static utils.testObjectBuilder.TestPetBuilder.getAddNewPetModel;

/**
 * This class contains tests for getting a pet by ID.
 */

@Epic("Get Pet By ID")
@Feature("Get Pet")
public class GetPetByIdTest extends BaseTest {

    @Severity(SeverityLevel.NORMAL)
    @Story("Get pet by ID - Happy Path")
    @Description("Check getting a pet by ID in a happy path scenario.")
    @Test
    public void testGetPetByID_HappyPath() {

        step("Create pet model request with /pet path", () -> {
            responseWrapper = petApiRequests.createNewPet(petRequest = getAddNewPetModel(VALID_RANDOM_PET_ID));
        });

        step("Get request with /pet/:petId path", () -> {
            responseWrapper = petApiRequests.getPetByID(VALID_RANDOM_PET_ID);
        });

        step(" Check response and petID", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        assertThat(response.getId())
                                .withFailMessage("ID doesn't match")
                                .isEqualTo(petRequest.getId());
                    }
            );

        });
    }
}

