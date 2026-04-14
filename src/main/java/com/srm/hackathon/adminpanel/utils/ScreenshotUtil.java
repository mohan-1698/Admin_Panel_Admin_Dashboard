package com.srm.hackathon.adminpanel.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;

import com.srm.hackathon.adminpanel.factory.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        WebDriver driver = DriverFactory.getDriver();

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/screenshots/"
                + testName + "_" + timestamp + ".png";

        File dest = new File(path);

        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}