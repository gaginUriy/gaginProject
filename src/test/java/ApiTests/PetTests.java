

import DataModel.DataCreatePet;
import DataModel.DataUpdetePet;
import TestSteps.ApiTestSteps;
import TestSteps.AssertionSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static io.qameta.allure.Allure.step;

public class PetTests {
    ApiTestSteps steps = new ApiTestSteps();
    AssertionSteps assertinSteps = new AssertionSteps();

    @Test
    @Description("Добавление питомца в Базе данных")
    public void CreatePet(){
        DataCreatePet createdPetId = step("Создание петомца",()->
            steps.CreatedPets()
        );
        DataCreatePet retrievedPet  =  step("проверить что питомец был создан",()->
             steps.getPets(createdPetId)
        );
        step("Проверить что петомиц был создан",()->
                assertinSteps.assertNameAndId(createdPetId,retrievedPet)
        );
    }

    @Test
    @Description("Обновление питомца в БД")
    public void UpdatePet(){
        DataCreatePet createdPetId = step("Создание петомца",()->
                steps.CreatedPets()
        );

        DataUpdetePet UpdatePet  = step("Обновить питомца",()->
               steps.updetePet(createdPetId)
        );
        step("Проверить что петомиц был обновлён",()->
                assertinSteps.assertNotEqualNameAndURL(createdPetId,UpdatePet)
        );
    }


    @Test
    @Description("Найти питомца по статусу")
    public void SertchPetByStatus(){
        DataCreatePet createdPetId = step("Создание петомца",()->
                steps.CreatedPets()
        );
        List<DataCreatePet> retrievedPet  =  step("Плучитьсписок петомцев по статусу",()->
                steps.getPetStatus()
        );
        step("Проверить что созданный петомец есть в списке в списеке",()->
                assertinSteps.assertEqualIdInArray(retrievedPet,createdPetId)
        );
      step("Проверить что в списеке полько петомцы с выбранным статусом",()->
                assertinSteps.assertEqualIdStatis(createdPetId,retrievedPet)
        );
    }
    @Test
    @Description("Удаление питомца из базы данных")
    public void DelidePet(){
        DataCreatePet createdPetId = step("Создание петомца",()->
                steps.CreatedPets()
        );

        DataCreatePet delitePetId = step("Удаление питомца",()->
                steps.DelitedPets(createdPetId)
        );

        DataCreatePet retrievedPet  =  step("проверить что питомец был создан",()->
                steps.getPets(delitePetId)
        );
        step("Проверить что петомиц был создан",()->
                assertinSteps.assertError(delitePetId)
        );



    }




}
