package com.teamtreehouse.countriesoftheworldwithspring.controller;

import com.teamtreehouse.countriesoftheworldwithspring.data.CountryRepository;
import com.teamtreehouse.countriesoftheworldwithspring.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountriesController {

  @Autowired
  private CountryRepository mCountryRepository;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/country/{countryName}")
  public String findCountryPage(@PathVariable String countryName, Model model){
    Country country = mCountryRepository.detailCountry(countryName);

    model.addAttribute("country", country);
    return "country";
  }

  @RequestMapping(value = "/sort/byName", method = RequestMethod.POST)
  public String sortByName(Model model){
    model.addAttribute("countries", mCountryRepository.sortByName());
    return "index";
  }

  @RequestMapping(value = "/sort/byPopulation", method = RequestMethod.POST)
  public String sortByPopulation(Model model){
    model.addAttribute("countries", mCountryRepository.sortByPopulation());
    return "index";
  }
}
