package com.govdvla.getvehicledetail;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"classpath:FeatureTest.feature"})

public class TestRunner {

}
