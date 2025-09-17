package TestTools;

import com.github.javafaker.*;

import java.util.Random;

public class GeneratedDataPets {
    Faker faker = new Faker();
    Random random = new Random();

    public int RandonID(){
        return faker.random().nextInt(9999999,999999999);
    }

    public String RandonPetName(){

        return faker.name().firstName();
    }

    public String RandonString(){
        return faker.random().hex(12);
    }


}
