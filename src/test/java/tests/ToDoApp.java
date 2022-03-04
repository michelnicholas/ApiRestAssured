package tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ToDoApp {

    private String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGFjMzZhZjgzM2MwMjAwMTcwNDYyMGEiLCJpYXQiOjE2MjE4OTg5Mjd9.Ke3gwU_jQM2wbDG57E03HPJztsfbHZpza6tRa3ZJxko";
    private String sessionToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGFjMzZhZjgzM2MwMjAwMTcwNDYyMGEiLCJpYXQiOjE2MjE4OTg5Mjl9.vjYxpiZfzGQON1ZdQnXT-QwiU1JnWqYSd4OHZGd2utY";
    private String userEmail = "alex42@gmail.com";
    private String baseUrl = "https://api-nodejs-todolist.herokuapp.com";
    private String updatedName = "Keira Dolan";
    private String taskId = "60ac4647833c02001704627f";

    @Test
    public void register_a_new_user(){

        Faker faker = new Faker();


        RestAssured.baseURI = baseUrl;
        String endpoint = "/user/login";
        String apiCall = baseUrl + endpoint;

        JSONObject json = new JSONObject();
        json.put("email" , "Michel Nicholas");
        json.put("password" , "Nicholas");
        String payload = json.toJSONString();

        RequestSpecification spec = RestAssured.given()
                        .config(RestAssuredConfig.config()
                .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("application.json", ContentType.TEXT)));
        spec.header("Content-Type","application.json")
                .header("Accept","application.json")
                .body(payload);


        Response response = spec.post(apiCall);

        int statusCode = response.statusCode();
        System.out.println("Status Code Recieved " + statusCode + "\n\n");
        response.getBody().prettyPrint();




    }




}
