import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class userController extends SetUp {
    public userController() throws IOException {
        initConfig();
    }


    public void dologin(String email,String password) throws ConfigurationException, IOException {
        RestAssured.baseURI=prop.getProperty("baseURl");
        userModel model = new userModel();
        model.setEmail(email);
        model.setPassword(password);
        Response res= given().contentType("application/json")
                .body(model).when().post("/user/login")
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(res.asString());

        JsonPath jsonObject = res .jsonPath();
        String token =  jsonObject.get("token");
        System.out.println(token);
        Utils.setEnvironment("token",token);
    }
    public void searchUser(String marchentAccount){
        RestAssured.baseURI=prop.getProperty("baseURl");
        Response res = given().contentType("application/json")
                .header("Authorization",prop.getProperty("token"))
                .when().get("/user/search/id/"+marchentAccount);
        System.out.println(res.asString());
    }
    public JsonPath createUser(userModel model){
        RestAssured.baseURI = prop.getProperty("baseURl");
        Response res = given().contentType("application/json")
                .body(model) . header("Authorization",prop.getProperty("token"))
                . header("X-AUTH-SECRET-KEY","ROADTOSDET")
                .when().post("/user/create");
        System.out.println(res.asString());
        return res.jsonPath();
    }
    public JsonPath depositToAgent(userModel model) {
        RestAssured.baseURI = prop.getProperty("baseURl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("SECRETKEY"))
                .when().post("transaction/deposit");
        System.out.println(res.asString());
        return res.jsonPath();
    }
    public JsonPath withdrawfromAgent(userModel model) {
        RestAssured.baseURI = prop.getProperty("baseURl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization", prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("SECRETKEY"))
                .when().post("transaction/withdraw");
        System.out.println(res.asString());
        return res.jsonPath();
    }
    public  JsonPath  sendMoneysecondUser(userModel model){
        RestAssured .baseURI = prop.getProperty("baseURl");
        Response res = given().contentType("application/json").body(model).header("Authorization",prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("SECRETKEY")).when().post("transaction/sendmoney");

        System.out.println(res.asString());
        return res.jsonPath();

    }
    public  JsonPath  paymentMarcent(userModel model){
        RestAssured .baseURI= prop.getProperty("baseURl");
        Response res = given().contentType("application/json").body(model)
                .header("Authorization",prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("SECRETKEY")).when().post("transaction/payment");
        System.out.println(res.asString());
        return res.jsonPath();

    }
    public void seeBalance( String marchentAccount){
        RestAssured.baseURI= prop.getProperty("baseURl");
        Response res = given().contentType("application/ json").header("Authorization",prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("SECRETKEY")).when().get("transaction/balance/"+marchentAccount);
        System.out.println(res.asString());
    }
}
