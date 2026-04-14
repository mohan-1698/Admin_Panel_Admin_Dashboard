package com.srm.hackathon.adminpanel.base;

import org.testng.annotations.*;

import com.srm.hackathon.adminpanel.factory.DriverFactory;
import com.srm.hackathon.adminpanel.utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}