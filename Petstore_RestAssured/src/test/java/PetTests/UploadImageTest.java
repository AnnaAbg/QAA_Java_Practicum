package PetTests;

import base.BaseTest;
import dto.response.APIResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.StatusCode.STATUS_CODE_OK;
import static utils.expectedObjectBuilder.ExpectedObjectBuilder.getUploadImageResponse;
import static utils.testDataHelper.TestDataPetHelper.VALID_RANDOM_PET_ID;

/**
 * This class contains tests for uploading an image for a pet.
 */

@Epic("Upload Pet Image")
@Feature("Upload Image")
public class UploadImageTest extends BaseTest {

    private static final String IMAGE_FILE_PATH = "src/test/resources/white-siberian-husky-puppy-on-green-grass-field-3812207.jpg";
    private static final String METADATA = "null";

    @Severity(SeverityLevel.NORMAL)
    @Story("Upload pet image - Happy Path")
    @Description("Check uploading an image for a pet in a happy path scenario.")
    @Test
    public void testUploadPetImage_HappyPath() {

        step("Create request with /pet/{petId}/uploadImage path ", () -> {
            responseWrapper = petApiRequests.uploadImage(VALID_RANDOM_PET_ID, METADATA, new File(IMAGE_FILE_PATH));
        });

        step("Check status code and response", () -> {
            int statusCode = responseWrapper.getStatusCode();
            APIResponse apiResponse = responseWrapper.as(APIResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(apiResponse)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getUploadImageResponse());
                    }
            );
        });
    }
}
