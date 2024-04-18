package MyNetworkStepDefinition;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DriverSetup.SetupDriver;
import Page.groupPageFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	static WebDriver driver;
	groupPageFactory pf;
	SetupDriver setup;

	@Given("User is logged In and is on home page")
	public void user_is_logged_in_and_is_on_home_page(DataTable dataTable) throws InterruptedException {
		driver = SetupDriver.chromedriver();
		pf = new groupPageFactory(driver);

		// pf.login("nitya.pathak19@gmail.com", "Nitya@2001~");

		List<List<String>> cells = dataTable.cells();
		pf.login(cells.get(0).get(0), cells.get(0).get(1));
		Thread.sleep(1000);
		pf.SwitchToHomePage();
	}

	@When("User clicks on Event icon on home page")
	public void User_clicks_on_Event_icon_on_home_page() throws InterruptedException {
		String title = driver.getTitle();
		Thread.sleep(2000);
		}

	@And("User enters the Event name")
	public void User_enters_the_Event_name() throws InterruptedException {
		pf.EventBtn();
		Thread.sleep(1000);
		pf.eventname("Join this event");
		pf.scroll();
		pf.scroll();
	}

	@And("User clicks on Next button")
	public void user_clicks_on_next_button() {
		pf.NextBtn();
	}

	@Then("User clicks on post button")
	public void user_clicks_on_post_button() throws InterruptedException {
		pf.ClickPost();
	}

	// ----------------------Connection Sort--------------------------
	@When("User clicks on My Network icon")
	public void user_clicks_on_my_network_icon() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		pf.NtwIcon();
	}

	@And("Clicks on Connection option")
	public void clicks_on_connection_option() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		pf.consort();

	}

	@And("Clicks on sort by drop down")
	public void clicks_on_sort_by_drop_down() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		pf.dropdownConnection();
	}

	@Then("Clicks on Recently added")
	public void clicks_on_recently_added() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		pf.first();
	}

	// -------------------------Repost--------------------------
	@When("User clicks on My Network icon1")
	public void user_clicks_on_My_Network_icon1() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		pf.NtwIcon();
	}

	@And("Clicks on Event option")
	public void Clicks_on_Event_option() throws InterruptedException {
		Thread.sleep(2000);
		pf.Events2();
	}

	@And("Clicks on previous events")
	public void clicks_on_previous_events() throws InterruptedException {
		pf.eventext();
		Thread.sleep(1000);
		pf.scroll();
	}

	@And("Clicks on Share button")
	public void clicks_on_share_button() throws InterruptedException, AWTException {

		pf.sharebtn();
	}

	@And("Click on Repost this post")
	public void click_on_repost_this_post() throws AWTException, InterruptedException {
		pf.ClickRepost();
	}

	@And("Enter the data")
	public void enter_the_data() throws InterruptedException {
		pf.clearingText();
		pf.ClickPostBtn();
	}

	@Then("Post the event on your feed")
	public void post_the_event_on_your_feed() {
		String msg1 = pf.textName();
		Assert.assertTrue(msg1.contains("Nitya Pathak"));

	}

	// ------------------------------Schedule-----------------------------------
	@When("User clicks on My Network")
	public void user_clicks_on_my_network() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		pf.NtwIcon();
	}

	@When("clicks on Event")
	public void clicks_on_event() throws InterruptedException {

		Thread.sleep(2000);
		pf.Events2();
	}

	@When("clicks on Create button")
	public void clicks_on_create_button() throws InterruptedException {

		Thread.sleep(2000);
		pf.ClickbtnEvent();
	}

	@When("Enter {string} of event")
	public void enter_of_event(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		pf.EventName(string);
	}

	@When("click on next")
	public void click_on_next() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		pf.nextbtnEvent();
	}

	@Then("click on Schedule button")
	public void click_on_schedule_button() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		pf.scheduleBtnClick();
		String msg1 = pf.textName();
		Assert.assertTrue(msg1.contains("Nitya Pathak"));
	}
//-------------------------------------------Invite  Event-----------------------------------------------------

	@When("User clicks on My Network icon2")
	public void user_clicks_on_my_network_icon2() throws InterruptedException {
		Thread.sleep(1000);
		pf.NtwIcon();
	}

	@When("Clicks on Event options")
	public void clicks_on_event_options() throws InterruptedException {
		Thread.sleep(2000);
		pf.Events2();
	}

	@When("Clicks on previous events name")
	public void clicks_on_previous_events_name() throws InterruptedException {
		pf.eventext();
		Thread.sleep(1000);
		pf.scroll();
	}

	@When("Clicks on Share button1")
	public void clicks_on_share_button1() throws InterruptedException, AWTException {
		pf.sharebtn();
	}

	@When("Clicks on Invite")
	public void clicks_on_invite() throws AWTException, InterruptedException {
		pf.ClickInvite();
	}

	@Then("Enter {string}")
	public void enter_ibm(String string1) throws InterruptedException {
		pf.CmpName();
		Thread.sleep(1000);
		pf.EventCm(string1);
		String msg = pf.text();
		Assert.assertTrue(msg.contains("Invite"));
	}

	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenerio.attach(src, "image/png", scenerio.getName());

	}
}
