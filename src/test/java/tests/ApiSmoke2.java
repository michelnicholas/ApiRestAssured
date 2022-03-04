package tests;

import groovyjarjarantlr.Token;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;





public class ApiSmoke2 {



    @Test
    public void verify_github_user_info(){
        RestAssured.baseURI = "https://api.github.com";
        String endpoint = "/users/michelnicholas";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Accept" , "application.json");
        Response response = requestSpecification.get(endpoint);

        int statusCode = response.statusCode();
        System.out.println("Recieved Status Code: " + statusCode + "\n\n");
        response.getBody().prettyPrint();

    }


    @Test
    public void verify_Nia(){
        RestAssured.baseURI = "https://facebook.com";
        String endpoint = "/profile.php?id=100070007919936";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Accept", "application.json");
        Response response = requestSpecification.get(endpoint);

        int statusCode = response.statusCode();
        System.out.println("Recieved Status Code: " + statusCode + "/n/n");
        response.getBody().prettyPrint();
    }









}
