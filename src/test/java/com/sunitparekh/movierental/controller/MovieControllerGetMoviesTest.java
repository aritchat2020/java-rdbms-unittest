package com.sunitparekh.movierental.controller;

import com.jayway.jsonpath.PathNotFoundException;
import com.sunitparekh.movierental.Application;
import com.sunitparekh.movierental.datafactory.MovieCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MovieControllerGetMoviesTest {

    @Autowired
    public WebApplicationContext wac;

    @Autowired
    public MovieCreator movieCreator;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        movieCreator.cleanup();
    }


    @Test
    public void shouldReturnOneMoviePresentInDatabase() throws Exception {
        movieCreator.createTheJungleBook();

        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/movies").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()",equalTo(1)))
                .andExpect(jsonPath("$[0].id",equalTo(1)))
                .andExpect(jsonPath("$[0].name",equalTo("The Jungle Book")))
                .andExpect(jsonPath("$[0].releaseYear",equalTo("2016")));
    }

    @Test
    public void shouldReturnAllThreeMoviePresentInDatabase() throws Exception {
        movieCreator.createTheJungleBook();
        movieCreator.createKungFuPanda3();
        movieCreator.createBatmanVsSupermanDawnofJustice();

        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/movies").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()",equalTo(3)));
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMoviesPresetInTheDatabase() throws Exception {
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/movies").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()",equalTo(0)));
    }

    @Test
    public void shouldNotHaveNameFieldPresentInJsonResponseForMovieWithoutName() throws Exception {
        movieCreator.createMovieWithoutName();

        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/movies").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()",equalTo(1)))
                .andExpect(jsonPath("$[0].id",equalTo(1)))
                .andExpect(jsonPath("$[0].name").doesNotExist());
    }
}