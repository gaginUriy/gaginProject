package TestSteps;

import DataModel.DataCreatePet;
import DataModel.DataUpdetePet;
import Pages.BasePage;
import TestTools.GeneratedDataPets;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.*;
import io.restassured.http.ContentType;


import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTestSteps {
    BasePage basePage = new BasePage();
    GeneratedDataPets GenPets = new GeneratedDataPets();
    final String baseUri = "https://petstore.swagger.io/v2";



    @Step("Создать петомца")
    public DataCreatePet  CreatedPets() {
        RestAssured.baseURI = baseUri;
        DataCreatePet.Category category = new DataCreatePet.Category(GenPets.RandonID(), GenPets.RandonString());
        DataCreatePet.Tag tag = new DataCreatePet.Tag(GenPets.RandonID(), GenPets.RandonString());
        DataCreatePet pet = new DataCreatePet();
        pet.setId(GenPets.RandonID());
        pet.setCategory(category);
        pet.setName(GenPets.RandonPetName());
        pet.setPhotoUrls(Arrays.asList(GenPets.RandonString()));
        pet.setTags(Arrays.asList(tag));
        pet.setStatus("pending");

        DataCreatePet petResponse = given()
                .filter(new AllureRestAssured())
                .log().all()
                .contentType(ContentType.JSON)
                .body(pet) // или .body(defaultPet)
                .when()
                .post("/pet")
                .then()
                .log().body()
                .statusCode(200)
                .log().status()
                .extract().as(DataCreatePet.class);
        return petResponse;
    }


    @Step("Получить питомца по ID ")
    public DataCreatePet getPets(DataCreatePet createdPetId){
        DataCreatePet petResponse = given()
                .baseUri(baseUri)
       .when()
                .get("/pet/"+createdPetId.getId())
                .then()
                .extract().as(DataCreatePet.class);
        return petResponse;
    }

    @Step("Получить питомца по статусу")
    public List<DataCreatePet> getPetStatus(){
        List<DataCreatePet>  petResponse = given()
                .baseUri(baseUri)
                .when()
                .get("pet/findByStatus?status=pending")
                .then()
                .extract().jsonPath().getList("", DataCreatePet.class);
        return petResponse;
    }

    @Step("Обновить питомца")
    public DataUpdetePet updetePet(DataCreatePet Pet){
        RestAssured.baseURI = baseUri;
        DataUpdetePet.Category category = new DataUpdetePet.Category(GenPets.RandonID(), GenPets.RandonString());
        DataUpdetePet.Tag tag = new DataUpdetePet.Tag(GenPets.RandonID(), GenPets.RandonString());
        DataUpdetePet pet = new DataUpdetePet();
        pet.setId(Pet.getId());
        pet.setCategory(category);
        pet.setName(GenPets.RandonPetName());
        pet.setPhotoUrls(Arrays.asList(GenPets.RandonString()));
        pet.setTags(Arrays.asList(tag));
        pet.setStatus("available");

        DataUpdetePet petResponse = given()
                .filter(new AllureRestAssured())
                .log().all()
                .contentType(ContentType.JSON)
                .body(pet) // или .body(defaultPet)
                .when()
                .put("/pet")
                .then()
                .log().body()
                .log().status()
                .extract().as(DataUpdetePet.class);
        return petResponse;


    }

    @Step("Удалить питомца")
    public DataCreatePet DelitedPets(DataCreatePet createdPetId){
        DataCreatePet petResponse = given()
                .baseUri(baseUri)
                .when()
                .delete("/pet/"+createdPetId.getId())
                .then()
                .extract().as(DataCreatePet.class);
        return petResponse;
    }



}





