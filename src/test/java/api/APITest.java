package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class APITest extends BaseAPI {

    UserAPI api = new UserAPI();

    @Test(priority = 1)
    public void createUser() {
        String requestBody = """
                {
                    "name" : "ojasGhambeera",
                     "email" : "ojass123@gmail.com",
                     "password" : "Ojas@123"
                }""";
        var response = api.createObject(requestBody);
        System.out.println(response.status());
        System.out.println(response.text());
        assertEquals(response.status(), 201);
        JsonObject json = JsonParser
                .parseString(response.text())
                .getAsJsonObject();

        try {
            String id = json.get("id").getAsString();
            System.out.println("Created ID: " + id);
        } catch (Exception e) {
            System.out.println("Account already created so unable to find ID ");
        }

    }

    @Test(priority = 2)
    public void loginUser() {
        String body = """
                {
                    "email" : "ojass123@gmail.com",
                    "password" :"Ojas@123"
                }
                """;
        var loginResponse = api.loginUser(body);
        System.out.println(loginResponse.status());
        System.out.println(loginResponse.text());
        assertEquals(loginResponse.status(), 200);
        JsonObject object = JsonParser.parseString(loginResponse.text()).getAsJsonObject();

        String token = object.get("data").getAsJsonObject().get("token").getAsString();
        System.out.println("Token | " + token);
        api.getAuth(token);


    }

    @Test(priority = 3)
    public void getParticularId() {
        var getResponse = api.getObject("5");
        System.out.println(getResponse.status());
        System.out.println("GET Response: " + getResponse.text());
    }

    @Test(priority = 4)
    public void deleteParticularID() {
        var getResponse = api.deleteObject("5");
        System.out.println(getResponse.status());
        System.out.println(getResponse.text());
    }
}