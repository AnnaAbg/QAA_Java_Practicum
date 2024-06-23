package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * The ScreenHelper class provides utility method for taking screenshots with WebDriver.
 * It utilizes the AShot library for capturing screenshots in PNG format.
 */
public class ScreenHelper {

    /**
     * Takes a screenshot of the current state of the WebDriver instance.
     *
     * @param driver the WebDriver instance - to capture the screenshot
     * @return a byte array representation of the captured screenshot in PNG format
     */
    @Attachment
    public static byte[] makeScreenShot(WebDriver driver) {
        Screenshot screenshot = new AShot().takeScreenshot(driver);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "PNG", buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toByteArray();
    }
}
