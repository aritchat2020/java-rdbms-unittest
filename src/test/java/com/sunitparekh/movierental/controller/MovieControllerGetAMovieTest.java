package com.sunitparekh.movierental.controller;

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

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MovieControllerGetAMovieTest {

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

        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/movies/1").accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id",equalTo(1)))
                .andExpect(jsonPath("$.name",equalTo("The Jungle Book")))
                .andExpect(jsonPath("$.releaseYear",equalTo("2016")))
                .andExpect(jsonPath("$.releaseDate",equalTo("2016-04-06")));
    }

}