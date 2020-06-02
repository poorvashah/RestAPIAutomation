package com.niit.utils;

import java.util.ArrayList;

public class TestUtil {
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        reader = new Xls_Reader("C:\\Users\\dell\\Desktop\\New folder\\RestAssuredFramework\\inputs\\Testdata.xlsx");
        for (int rownum = 2; rownum <= reader.getRowCount("GetAPI"); rownum++) {
            String host = reader.getCellData("GetAPI", "EndPoint", rownum);
            String ContentType = reader.getCellData("GetAPI", "ContentType", rownum);
            String application = reader.getCellData("GetAPI", "Application", rownum);
            String applicationjson = reader.getCellData("GetAPI", "Json", rownum);
            System.out.println(host);
            System.out.println(ContentType + application + applicationjson);
            Object ob[] = {host, ContentType, application, applicationjson};
            myData.add(ob);

        }
        return myData;
    }

    public static ArrayList<Object[]> getPostDataFromExcel() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        reader = new Xls_Reader("C:\\Users\\dell\\Desktop\\New folder\\RestAssuredFramework\\inputs\\Testdata.xlsx");
        for (int rownum = 2; rownum <= reader.getRowCount("PostAPI"); rownum++) {
            String host = reader.getCellData("PostAPI", "EndPoint", rownum);
            String ContentType = reader.getCellData("PostAPI", "ContentType", rownum);
            String application = reader.getCellData("PostAPI", "Application", rownum);
            String applicationjson = reader.getCellData("PostAPI", "Json", rownum);
            System.out.println(host);
            System.out.println(ContentType + application + applicationjson);
            Object ob[] = {host, ContentType, application, applicationjson};
            myData.add(ob);

        }
        return myData;



          }


    public static ArrayList<Object[]> getDeleteDataFromExcel() {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        reader = new Xls_Reader("C:\\Users\\dell\\Desktop\\New folder\\RestAssuredFramework\\inputs\\Testdata.xlsx");
        for (int rownum = 2; rownum <= reader.getRowCount("DeleteAPI"); rownum++) {
            String host = reader.getCellData("DeleteAPI", "EndPoint", rownum);
            String ContentType = reader.getCellData("DeleteAPI", "ContentType", rownum);
            String application = reader.getCellData("DeleteAPI", "Application", rownum);
            String applicationjson = reader.getCellData("DeleteAPI", "Json", rownum);
            String newstepid = reader.getCellData("DeleteAPI", "newstepid", rownum);
            String [] x =newstepid.split("\\.");
            int n = x.length;
            newstepid = x[0];
            System.out.println(n);
            System.out.println(host);
            System.out.println(ContentType + application + applicationjson+newstepid);
            Object ob[] = {host, ContentType, application, applicationjson,newstepid};
            myData.add(ob);

        }
        return myData;
    }


    public static  void main (String[] args)
    {

        TestUtil.getDeleteDataFromExcel();
    }
}