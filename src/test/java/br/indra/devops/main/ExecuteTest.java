package br.indra.devops.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, format = {
		"json:target/surefire-reports/br.indra.devops.main.ExecuteTestResult.json" }, features = "src/test/resources/features", glue = {
				"br.indra.devops.steps" }, monochrome = true)
public class ExecuteTest {
}
