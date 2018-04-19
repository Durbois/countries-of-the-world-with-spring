package com.teamtreehouse.countriesoftheworldwithspring.data;

import com.teamtreehouse.countriesoftheworldwithspring.model.Country;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class CountryRepository {

  private static final List<Country> ALL_COUNTRIES = Arrays.asList(
      new Country("ecuador", 1230000000, "Quito", Arrays.asList("English", "Spanish")),
      new Country("france", 194000000, "Paris", Arrays.asList("French")),
      new Country("india", 185000000, "Neu-Delhi", Arrays.asList("English", "Hindu")),
      new Country("italy", 106000000, "Rom", Arrays.asList("Italian")),
      new Country("kenya", 117000000, "Nairobi", Arrays.asList("Swahili", "English"))
  );

  public List<Country> sortByName(){
    ALL_COUNTRIES.sort(new Comparator<Country>() {
      @Override
      public int compare(Country o1, Country o2) {
        return o1.getCountryName().compareTo(o2.getCountryName());
      }
    });

    return ALL_COUNTRIES;
  }

  public List<Country> sortByPopulation(){
    ALL_COUNTRIES.sort(new Comparator<Country>() {
      @Override
      public int compare(Country o1, Country o2) {
        return (int) (o1.getPopulation() - o2.getPopulation());
      }
    });

    return ALL_COUNTRIES;
  }

  public Country detailCountry(String countryName){
    return ALL_COUNTRIES.stream()
        .filter(c -> c.getCountryName().equalsIgnoreCase(countryName))
        .findFirst()
        .get();
  }


}
