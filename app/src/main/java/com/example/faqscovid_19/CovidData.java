package com.example.faqscovid_19;

public class CovidData {

    String countryName;
    String totalCases;
    String newCases;
    String totalDeaths;
    String newDeaths;
    String totalRecovered;
    String newRecovered;

    public CovidData(String countryName, String totalCases, String newCases, String totalDeaths, String newDeaths, String totalRecovered, String newRecovered) {
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.newRecovered = newRecovered;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public String getNewRecovered() {
        return newRecovered;
    }

    @Override
    public String toString() {
        return this.countryName;
    }
}
