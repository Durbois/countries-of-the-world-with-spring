package com.teamtreehouse.countriesoftheworldwithspring.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.teamtreehouse.countriesoftheworldwithspring.data.CountryRepository;
import com.teamtreehouse.countriesoftheworldwithspring.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CountriesControllerTest {

  private MockMvc mMockMvc;

  @InjectMocks
  private CountriesController mCountriesController;

  @Mock
  private CountryRepository mCountryRepository;

  @Before
  public void setUp() throws Exception {
    mMockMvc = MockMvcBuilders.standaloneSetup(mCountriesController).build();
  }

  @Test
  public void shouldFindKenya() throws Exception {
    Country kenya = new Country("kenya", 123456789, "Nairobi", Arrays.asList("Swahili", "English"));
    when(mCountryRepository.detailCountry("kenya")).thenReturn(kenya);

    mMockMvc.perform(get("/country/kenya"))
            .andExpect(status().isOk())
            .andExpect(view().name("kenya"))
            .andExpect(model().attribute("country", kenya));

    verify(mCountryRepository).detailCountry("kenya");
  }
}