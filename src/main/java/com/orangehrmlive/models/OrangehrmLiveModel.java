package com.orangehrmlive.models;

public class OrangehrmLiveModel {

    private String name;
    private String currency;
    private String maximum;
    private String minimum;
    private String currencyResponse;


    public String getCurrencyResponse() {
        return currencyResponse;
    }

    public void setCurrencyResponse(String currencyResponse) {
        this.currencyResponse = currencyResponse;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
