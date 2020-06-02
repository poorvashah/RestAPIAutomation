package com.niit.jiraApiTest;

import com.niit.extentReport.GenerateExtendReport;
import com.niit.json.JsonFileGenerator;
import com.niit.utils.FileandEnv;
import com.niit.utils.TestUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PostAPITest extends GenerateExtendReport {

//verify post call
@DataProvider()
public Iterator<Object[]> postTestData(){
    ArrayList<Object[]> al = TestUtil.getPostDataFromExcel();
    return al.iterator();
}

    @Test(dataProvider = "postTestData")
    public void testCreateStep(String host, String ContentType, String application,
                               String applicationjson) throws IOException {
        logger=extent.createTest("Verify post Request");
        RestAssured.baseURI = "https://sandbox.xpand-it.com";


        Response response_PostTestStep=RestAssured.given().auth().preemptive()
                .basic(FileandEnv.envAndFile().get("username"), FileandEnv.envAndFile().get("password"))
                .header(ContentType, application + "/" + applicationjson)
                .body(JsonFileGenerator.GenerateStringFromResource("C:\\Users\\dell\\Desktop\\testStep.json"))
                .when()
                .put(host).then().log().all().extract().response();

        Assert.assertEquals(200, response_PostTestStep.getStatusCode());

    }
}
