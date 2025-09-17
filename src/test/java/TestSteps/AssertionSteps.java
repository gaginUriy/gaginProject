package TestSteps;

import DataModel.DataCreatePet;
import DataModel.DataUpdetePet;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssertionSteps {


    private DataCreatePet createdPetid;
    private List<DataCreatePet> pets;

    @Step("Проверить поле что поля Имя и ID совпадают с шагом создания")
    public void assertNameAndId(DataCreatePet createdPet, DataCreatePet responsePet){
       assertThat(responsePet.getId())
               .as("Проверка соответствия ID")
               .isEqualTo(createdPet.getId());

       assertThat(responsePet.getName())
               .as("Проверка соответствия имени")
               .isEqualTo(createdPet.getName());

    }
    @Step("Проверить поле что поля Имя и URL не совпадают с шагом создания")
    public void assertNotEqualNameAndURL(DataCreatePet createdPet, DataUpdetePet updatePet){
        assertThat(updatePet.getPhotoUrls())
                .as("Проверка соответствия ID")
                .isNotEqualTo (createdPet.getPhotoUrls());

        assertThat(updatePet.getName())
                .as("Проверка соответствия имени")
                .isNotEqualTo(createdPet.getName());

        assertThat(updatePet.getId())
                .as("Проверка соответствия ID")
                .isEqualTo(createdPet.getId());

    }
    @Step("что в массиве есть добавленный петомец")
    public void assertEqualIdInArray(List<DataCreatePet> pets, DataCreatePet createdPetName){
        List<String> petID  = new ArrayList<>();
        for (DataCreatePet pet : pets) {
            petID.add(pet.getName());
        }
        assertTrue(petID.contains(createdPetName.getName()));


    }
    @Step("что в массиве полько выбранные статус")
    public void assertEqualIdStatis(DataCreatePet createdPet, List<DataCreatePet> updatePet){
        for (DataCreatePet pet : updatePet) {
            Assertions.assertEquals(
                    createdPet.getStatus(),
                    pet.getStatus());
        }



    }
    @Step("Проверить поле что поля Имя и ID совпадают с шагом создания")
    public void assertError(DataCreatePet value){
        assertThat(value).isEqualTo("Pet not found");



    }

}
