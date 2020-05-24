package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static void screenshot (WebDriver driver, String screenshotName) {
		Path path = Paths.get(Constants.Path_Screenshots, screenshotName+".PNG");
		try {
			Files.createDirectories(path.getParent());
			FileOutputStream output = new FileOutputStream(path.toString());
			output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
