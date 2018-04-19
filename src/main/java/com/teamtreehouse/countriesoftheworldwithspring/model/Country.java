package com.teamtreehouse.countriesoftheworldwithspring.model;

import java.util.ArrayList;
import java.util.List;

public class Country {

  private String countryName;
  private long population;
  private String capitalCity;
  private List<String> languages;

  public Country(String countryName, long population, String capitalCity,
                 List<String> languages) {
    this.countryName = countryName;
    this.population = population;
    this.capitalCity = capitalCity;
    this.languages = languages;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public long getPopulation() {
    return population;
  }

  public void setPopulation(long population) {
    this.population = population;
  }

  public String getCapitalCity() {
    return capitalCity;
  }

  public void setCapitalCity(String capitalCity) {
    this.capitalCity = capitalCity;
  }

  public boolean add(String language) {
    return languages.add(language);
  }

  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }
}
