//package com.cucumber.junit.driver;
//
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//
//public class Capabilities {
//
//	public static DesiredCapabilities getChromeOptions() {
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--test-type");
//		chromeOptions.addArguments("--ignore-certificate-errors");
//
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//
//		return capabilities;
//	}
//}