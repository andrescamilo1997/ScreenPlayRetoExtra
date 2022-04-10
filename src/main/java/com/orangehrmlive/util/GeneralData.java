package com.orangehrmlive.util;

import com.github.javafaker.Faker;
import com.orangehrmlive.models.OrangehrmLiveModel;

import java.util.Locale;

import static com.orangehrmlive.util.Constants.*;

public class GeneralData {

    private     static  OrangehrmLiveModel   orangehrmLiveModel;
    private     static  Faker                faker;
    private     static  String               name;
    private     static  String               currency;
    private     static  String               maximum;
    private     static  String               minimum;
    private     static  String               currencyResponse;
    private     static  int                  randomNumber;
    private     static  int                  littleRandom;


    public static OrangehrmLiveModel generalDates(){
        faker = new Faker();

        name = faker.name().title();

        littleRandom = faker.number().numberBetween(1,3);
        currency = selectCurrency(littleRandom);
        currencyResponse = currencyResponse(littleRandom);



        randomNumber = faker.number().numberBetween(numberMin,numberMax);
        minimum = String.valueOf(randomNumber);
        maximum = String.valueOf(randomNumber+NUMBERTOADD);


        orangehrmLiveModel = new OrangehrmLiveModel();
        orangehrmLiveModel.setName(name);
        orangehrmLiveModel.setCurrency(currency);
        orangehrmLiveModel.setMaximum(maximum);
        orangehrmLiveModel.setMinimum(minimum);
        orangehrmLiveModel.setCurrencyResponse(currencyResponse);

        return orangehrmLiveModel;
    }

    public static String selectCurrency(int numberToSelect){
        switch (numberToSelect){
            case 1:
                return currencies;
            case 2:
                return currencies1;
            default:
                return currencies2;
        }
    }

    public static String currencyResponse(int numberToSelect){
        switch (numberToSelect){
            case 1:
                return currenciesResponse;
            case 2:
                return currenciesResponse1;
            default:
                return currenciesResponse2;
        }
    }

    public static String reformatNumber(String textToFormat){
        int a = Integer.parseInt(textToFormat);
        return String.format(Locale.ENGLISH,"%,d",a)+".00";
    }


}
