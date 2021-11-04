package com.cucumber.junit.util;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Waiter;


public class ShouldConditions {
	public void waitUntilElementClickable(By locator) {
		$(locator).should(Condition.appear);
	}

	public void waitUntilElementVisible(By locator) {
		$(locator).should(Condition.visible);
	}

//	public <T> void wait(By subject, Condition condition, long timeout, long pollingInterval) {
//		Waiter wait = new Waiter();
//		wait.wait();
//	}
}