package com.srm.hackathon.adminpanel.tests;

import org.testng.annotations.Test;

import com.srm.hackathon.adminpanel.factory.DriverFactory;
import com.srm.hackathon.adminpanel.utils.ConfigReader;

public class DriverTest {

    @Test
    public void testDriverSetup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(ConfigReader.getBaseUrl());

        System.out.println("Title: " + DriverFactory.getDriver().getTitle());

        DriverFactory.quitDriver();
    }
}