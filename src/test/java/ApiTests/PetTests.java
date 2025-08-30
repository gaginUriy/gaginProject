package ApiTests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class PetTests {


    @Test
    public void CreatePet(){
        get ("werw")
                .then()
                .log().all()


    }

}
