package Tests;

import Reusables.ReusableMethods;
import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_001 extends TestBase {

    ReusableMethods reusable = new ReusableMethods();

    @Test(priority = 0)
    public void availablePet(){
        reusable.totalAvailable();
    }

    @Test(priority = 1)
    public void addPet(){
        reusable.addPet(id,name,"available");
        String responseName = reusable.getData(id, "name");
        Assert.assertEquals(responseName, name, "Pet isn't Added");
    }

    @Test(priority = 2)
    public void updatePet(){
        reusable.updatePet(id,name,"sold");
        String responseName = reusable.getData(id, "status");
        Assert.assertEquals(responseName, "sold", "Pet status isn't Updated");
    }

    @Test(priority = 3)
    public void deletePet(){
        reusable.deletePet(id);
        int statusCode = reusable.getStatusCode(reusable.getResponse(id));
        Assert.assertEquals(statusCode,404, "Not Deleted Successfully");
    }
}
