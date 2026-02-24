package api;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;

public class UserAPI extends BaseAPI{

    protected static String authToken;

    public APIResponse createObject(String body){
        return requestContext.post("/notes/api/users/register", RequestOptions.create().setData(body));
    }
    public APIResponse getObject(String id){
        return requestContext.get("/notes/api/notes/"+id,RequestOptions.create().setHeader("x-auth-token",authToken));
    }
    public APIResponse deleteObject(String id){
        return requestContext.delete("/notes/api/notes/"+id,RequestOptions.create().setHeader("x-auth-token",authToken));
    }
    public APIResponse loginUser(String body){
        return requestContext.post("/notes/api/users/login",
                RequestOptions.create().setData(body));
    }

    public void getAuth(String key){
        authToken = key;
    }
}
