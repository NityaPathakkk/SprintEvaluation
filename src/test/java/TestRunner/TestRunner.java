package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features="Resource\\Features",glue="MyNetworkStepDefinition")
//plugin = {"pretty","html:target/HTMLReports/LinkedinReports1.html",
//		"json:target/JSONReports/LinkedinReports1.json",
//        "junit:target/JUNITReport/LinkedinReports1.xml",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests{
}