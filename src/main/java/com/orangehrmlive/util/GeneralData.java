package com.orangehrmlive.util;

import com.github.javafaker.Faker;
import com.orangehrmlive.models.OrangehrmLiveModel;

import java.util.Locale;

import static com.orangehrmlive.util.Constants.*;

public class GeneralData {

    private static OrangehrmLiveModel orangehrmLiveModel;
    private static Faker faker;
    private static String name;
    private static String currency;
    private static String maximum;
    private static String minimum;
    private static int randomNumber;


    public static OrangehrmLiveModel generalDates(){
        faker = new Faker();

        name = faker.name().title();

        currency = currencies;
        randomNumber = faker.number().numberBetween(numberMin,numberMax);



        minimum = String.valueOf(randomNumber);

        maximum = String.valueOf(randomNumber+20);


        orangehrmLiveModel = new OrangehrmLiveModel();
        orangehrmLiveModel.setName(name);
        orangehrmLiveModel.setCurrency(currency);
        orangehrmLiveModel.setMaximum(maximum);
        orangehrmLiveModel.setMinimum(minimum);

        return orangehrmLiveModel;
    }

    public static String reformatNumber(String textToFormat){
        int a = Integer.parseInt(textToFormat);
        return String.format(Locale.ENGLISH,"%,d",a)+".00";
    }


}
