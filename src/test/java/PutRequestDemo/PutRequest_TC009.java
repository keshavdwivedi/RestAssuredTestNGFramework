package PutRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutRequest_TC009 {

    @Test
    public void putRequest_verifyPutRequest(){
        //base URI declared
        RestAssured.baseURI="https://reqbin.com/";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //request payload sent along with post request
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Id","12345");
        jsonObject.put("Customer","John Smith");
        jsonObject.put("Quantity","1");
        jsonObject.put("Price","10.00");


        httpRequest.body(jsonObject.toJSONString());

        //response object
        Response response=httpRequest.request(Method.PUT,"/echo/put/json");
        System.out.println(response.getBody().asString());

        //assert status code
        Assert.assertEquals(response.getStatusCode(),200);

        //verify response json node value
        Assert.assertEquals(response.jsonPath().get("success"),"true");



    }
}
