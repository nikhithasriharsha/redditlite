package com.vidala.redditlite.cucumber.stepdefs;

import com.vidala.redditlite.RedditliteApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = RedditliteApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
