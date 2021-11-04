package com.cucumber.junit.hooks;

import org.openqa.selenium.OutputType;

import com.codeborne.selenide.Selenide;

import io.cucumber.java.*;


public class DriverHooks {

	@After
	public void screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screen = Selenide.screenshot(OutputType.BYTES);
			scenario.attach(screen, "image/png", scenario.getName());
		}
	}
}
