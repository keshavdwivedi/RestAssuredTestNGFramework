package GetRequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class GetRequest_TC006 {

    @Test
    public void getRequest_extractvalue_eachnode_jsonpath(){

        //request URI
        RestAssured.baseURI="https://reqres.in";

        //request object
        RequestSpecification httpRequest=RestAssured.given();

        //response object
        Response response =httpRequest.request(Method.GET,"/api/users/2");

        System.out.println(response.getBody().asString());

        //using jsonpath with response to capture entire response in jsonpath variable
        JsonPath jsonPath=response.jsonPath();

        //System.out.println(jsonPath.getString("data.id")); accessing nested json by jsonpath

        //parse json with hashmap
        Map<String,String>data=jsonPath.getMap("data");
        Assert.assertEquals(data.get("id"),2);
        Assert.assertEquals(data.get("email"),"janet.weaver@reqres.in");
        Assert.assertEquals(data.get("first_name"),"Janet");
        Assert.assertEquals(data.get("last_name"),"Weaver");

    }

}
