package com.ashu.as_codepicker;

public class ModelCountyCode {

    String shortCode;
    String countryCode;
    String name;
    String withPlus;

    public ModelCountyCode(String shortCode, String countryCode, String name) {
        this.shortCode = shortCode;
        this.countryCode = countryCode;
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getWithPlus() {
        return "+"+getCountryCode();
    }

    public void setWithPlus(String withPlus) {
        this.withPlus = withPlus;
    }
}
