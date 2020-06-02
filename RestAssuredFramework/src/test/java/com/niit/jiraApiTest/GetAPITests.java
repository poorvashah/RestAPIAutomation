package com.niit.jiraApiTest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import com.niit.extentReport.GenerateExtendReport;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.niit.utils.FileandEnv;
import com.niit.utils.TestUtil;

public class GetAPITests extends GenerateExtendReport{


    @DataProvider()
    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> al = TestUtil.getDataFromExcel();
        return al.iterator();
    }


    @Test(dataProvider = "getTestData")
    public void getJiraTestSteptatus(String host, String ContentType, String application, String applicationjson ) {

        logger=extent.createTest("Verify Get Request");
        RestAssured.baseURI = "https://sandbox.xpand-it.com";


       Response response = RestAssured.given().auth().preemptive()
                .basic(FileandEnv.envAndFile().get("username"), FileandEnv.envAndFile().get("password"))
                .header(ContentType, application + "/" + applicationjson)
                .when().get(host);
        long time=response.time();
       //logger.log(Status.INFO, "API response time taken" + time + "ms");

        Assert.assertEquals(200, response.getStatusCode());

          }
}
