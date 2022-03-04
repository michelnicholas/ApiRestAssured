package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APISmokeTest {


    @Test
    public void verify_github_user_info() {
        //  GET https://api.github.com/users/yasunaz1990
        RestAssured.baseURI = "https://api.github.com";
        String endpoint = "/users/yasunaz1990";


        // 1. Request Specifications
        // Request Headers
        // Request Body
        // Request Line

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.header("Accept", "application/xml");
        Response response = reqSpec.get(endpoint);

        // 2. Response Parts
        // Response Status Line
        // Response Body
        // Response Headers

        int statusCode = response.statusCode();
        System.out.println("Received Status Code:  " + statusCode + "\n\n");
        response.getBody().prettyPrint();
    }

    @Test
    public void verify_contact_list(){
        // Get http://3.13.86.142:3000/contacts

        RestAssured.baseURI = "http://3.13.86.142:3000";  // base url
        String endpoint = "/contacts";                      // endpoint of url

        RequestSpecification spec = RestAssured.given();    //
        spec.header("Accept", "application/json");      // only recieve json

        Response response = spec.get(endpoint);

        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved: " + statusCode + "\n\n");  // returning response status code
        response.getBody().prettyPrint();


    }

    @Test
    public void get_list_user(){
        RestAssured.baseURI = "https://reqres.in/"; // base url
        String endpoint = "/api/users?page=2";

        RequestSpecification spec = RestAssured.given();
        spec.header("Accept","application/json");

        Response response = spec.get(endpoint);

        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved: " + statusCode + "\n\n");
        response.getBody().prettyPrint();


    }

    @Test
    public void get_single_user(){
        RestAssured.baseURI = "https://reqres.in/";
        String endpoint = "/api/users/2";

        RequestSpecification spec = RestAssured.given();
        spec.header("Accept","application/json");

        Response response = spec.get(endpoint);
        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved: " + statusCode + "\n\n");
        response.getBody().prettyPrint();

    }

    @Test
    public void single_user_not_found(){
        RestAssured.baseURI = "https://reqres.in/";
        String endpoint = "/api/users/2";

        RequestSpecification spec = RestAssured.given();
        spec.header("Accept", "application/json");

        Response response = spec.get(endpoint);
        int statusCode = response.statusCode();
        System.out.println("Status Code Received: " + statusCode + "\n\n");
        response.getBody().prettyPrint();
    }

    @Test
    public void list_resource(){
        RestAssured.baseURI = "https://reqres.in/";
        String endpoint = "/api/unknown";

        RequestSpecification spec = RestAssured.given();
        spec.header("Accept","application/json");

        Response response = spec.get(endpoint);
        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved:" + statusCode + "\n\n");

        response.getBody().prettyPrint();
    }

    @Test
    public void single_resource(){
        RestAssured.baseURI = "https://reqres.in/";
        String endpoint = "/api/unknown/2";

        RequestSpecification spec = RestAssured.given();
        spec.header("Accept","application/json");

        Response response = spec.get(endpoint);
        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved" +  statusCode + "\n\n");
        response.getBody().prettyPrint();


    }




}
