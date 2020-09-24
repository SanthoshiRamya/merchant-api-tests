package com.merchant.api.tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
    public String runId = String.valueOf(System.currentTimeMillis()).substring(5, 12);

    @BeforeClass
    public void beforeClass(ITestContext context) {
        RestAssured.baseURI = context.getCurrentXmlTest().getParameter("BaseURI");
    }
}
