package com.niit.jiraApiTest;
//Verifying Delete call
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



public class DeleteAPITest extends GenerateExtendReport {

    @DataProvider()
    public Iterator<Object[]> postdeleteTestData() {
        ArrayList<Object[]> al = TestUtil.getDeleteDataFromExcel();
        return al.iterator();
    }

    @Test(dataProvider = "postdeleteTestData")
// Below API will be executed ony after post API execution. Pass the id from post API  to delete API sheet.

    public void testCreateStep(String host, String ContentType, String application,
                               String applicationjson, String newstepid) throws IOException {
        logger=extent.createTest("Verify delete Request");
        RestAssured.baseURI = "https://sandbox.xpand-it.com";

        Response response_DeleteTestStep = RestAssured.given().log().all().
                auth().preemptive()
                .basic(FileandEnv.envAndFile().get("username"), FileandEnv.envAndFile().get("password"))
                .header(ContentType, application + "/" + applicationjson)
                .body(JsonFileGenerator.GenerateStringFromResource("C:\\Users\\dell\\Desktop\\testStep.json"))
                .when()
                .delete(host + "/" + newstepid).then().log().all().extract().response();
        //System.out.println(response_PostTestStep);

        Assert.assertEquals(200, response_DeleteTestStep.getStatusCode());

    }
}