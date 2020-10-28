
package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Arrays;


public class Test_stJohn_charity {

    @Test
    public void test() {

        Response response = RestAssured.get("https://api.trademe.co.nz/v1/Charities.json");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String charityNames = response.jsonPath().getString("Description");
        System.out.println("List of Charities: "+ charityNames);
        Arrays.asList(charityNames).contains("St John");

    }


}

/*
Output:
200
[{"CharityType":1,"ImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/kiwis-for-kiwi-logo-3x.png","DarkModeImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/kiwis-for-kiwi-logo-3x.png","Description":"Kiwis for kiwi","Tagline":"Protecting kiwi and the places they live."},{"CharityType":2,"ImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/plunket-logo-3x.png","DarkModeImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/plunket-logo-3x.png","Description":"Plunket","Tagline":"A major provider of well child health services in NZ."},{"CharityType":3,"ImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/st_john_logo_light.png","DarkModeImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/st_john_logo_dark.png","Description":"St John","Tagline":"To support St John Christchurch in the work they do in our community."},{"CharityType":4,"ImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/chch_foundation_light.png","DarkModeImageSource":"https:\/\/www.trademe.co.nz\/images\/sell\/chch_foundation_dark.png","Description":"Our People, Our City Fund","Tagline":"This will be used to support the families and Muslim communities impacted by the tragic events in Christchurch."}]
HTTP/1.1 200 OK
List of Charities: [Kiwis for kiwi, Plunket, St John, Our People, Our City Fund]

 */
