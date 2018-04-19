package com.teamtreehouse.countriesoftheworldwithspring.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryRepositoryTest {


  private CountryRepository mCountryRepository;

  @Before
  public void setUp() throws Exception {
    mCountryRepository = new CountryRepository();
  }

  @Test
  public void shouldReturnCountryByName(){
    assertNotNull(mCountryRepository.detailCountry("Kenya"));
  }

}