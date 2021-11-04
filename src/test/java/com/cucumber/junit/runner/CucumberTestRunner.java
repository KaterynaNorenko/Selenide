package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber-reports/Cucumber.html"},
		monochrome = true,
		tags = "@smoke",
		glue = "com.cucumber.junit",
		features = "classpath:com/cucumber/junit/features")

public class CucumberTestRunner {
}
