package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Test_UsedCar {

    @Test
    public void test() {
        RestAssured.baseURI ="https://api.trademe.co.nz/v1/Search/Motors/Used.json";
        /* BDD style*/
        given().contentType(ContentType.JSON).
                //.oauth2(token)
                when().get("").
                then().log().status().
                and().
                log().body().
                and().statusCode(200); //checks status code

    }
}

/*

Output:
HTTP/1.1 401 Unauthorized
{
    "Request": "https://api.trademe.co.nz/v1/Search/Motors/Used.json",
    "ErrorDescription": "This API requires that you supply your application credentials.  Please see the authorization section of the developer website for details."
}
 */
