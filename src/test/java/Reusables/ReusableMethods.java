package Reusables;

import Base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods extends TestBase {

    public void totalAvailable(){
        try {
            Response responseNew = request.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
            JsonPath jsonPathEvaluator = responseNew.jsonPath();
            List<ArrayList> list = jsonPathEvaluator.get("status");
            logger.info("Total Available: "+list.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addPet(int id, String name, String status){
        try {
            JSONObject requestParams = new JSONObject();
            requestParams.put("id", id);
            requestParams.put("name", name);
            requestParams.put("status", status);

            request.header("Content-Type", "application/json");
            request.body(requestParams.toString());
            Response response = request.post();
            if (response.getStatusCode() == 200) {
                logger.info("Pet Added Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getData(int id, String property){
        JsonPath jsonPathEvaluatorName = getResponse(id).jsonPath();
        String responseName = jsonPathEvaluatorName.get(property);
        return responseName;
    }

    public void updatePet(int id, String name, String status){
        try {
            JSONObject requestParams = new JSONObject();
            requestParams.put("id", id);
            requestParams.put("name", name);
            requestParams.put("status", status);

            request.header("Content-Type", "application/json");
            request.body(requestParams.toString());
            Response response = request.put();
            if (response.getStatusCode() == 200) {
                logger.info("Pet details updated Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getStatusCode(Response response){
        return response.getStatusCode();
    }

    public void deletePet(int id){
        try{
            request.header("Content-Type", "application/json");
            Response response = request.delete("/"+id);
            if(getStatusCode(response)==200){
                logger.info("Deleted Successfully");
            }
            else{
                logger.info("Not Deleted");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Response getResponse(int id){
        Response response = request.get("/"+id);
        return response;
    }
}
