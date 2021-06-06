package GetRequestDemo;

import ApiUtils.ApiUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest_TC001 {

    @Test
    public void getRequest_verifyStatuscode_statusLine(){

        String encodedApiKey="ZmFiNWVlYjc5ZmVmNDRmMzg0NjUzMDU1MjEwNTA2";
        //declaring base URI
        RestAssured.baseURI="http://api.weatherapi.com/v1";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/current.json?key="+ ApiUtility.decodeString(encodedApiKey) +"&q=Lucknow&aqi=yes");

        //print response body
        System.out.println(response.getBody().asString());

        //verify status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify status line
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");


    }
}
