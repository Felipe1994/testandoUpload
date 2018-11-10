package br.indra.devops.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class TestSteps {

	WebDriver driver;
	WebElement e;
	final static Logger log = Logger.getLogger(TestSteps.class);

	@Given("^the land page is loaded$")
	public void the_land_page_is_loaded() throws Throwable {
		FirefoxDriverManager.getInstance().forceCache().setup();
		driver = new FirefoxDriver();
		// ChromeDriverManager.getInstance().forceCache().setup();
		// driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		log.warn("Acessando o site");
	}

	@When("^I scroll the page$")
	public void i_scroll_the_page() throws Throwable {
		e = driver.findElement(By.id("rt-footer-surround"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
		log.info("rolando a pagina");
	}

	@Then("^I can see all the panels$")
	public void i_can_see_all_the_panels() throws Throwable {
		assertTrue(e.isDisplayed());
		driver.quit();
		log.warn("Encerrando o teste");
	}
}
