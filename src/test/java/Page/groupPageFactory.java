package Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class groupPageFactory {
	WebDriver driver;
	@FindBy(xpath = "//input[@id=\"session_key\"]")
	@CacheLookup
	WebElement email;
	@FindBy(xpath = "//input[@id=\"session_password\"]")
	@CacheLookup
	WebElement password;
	@FindBy(xpath = "//button[@data-id=\"sign-in-form__submit-btn\"]")
	WebElement lgbtn;


	@FindBy(xpath = "//button[@title=\"Create an event\"]")
	WebElement event;

	@FindBy(id = "ef-form__name")
	WebElement eventname;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement next;

	public void ClickNext() {
		next.click();
	}

	@FindBy(xpath = "//span[text()='Post']")
	WebElement post;

	public void ClickPost() throws InterruptedException {
		Thread.sleep(1000);
		post.click();
	}

	public groupPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String uname, String pwd) throws InterruptedException {

		email.sendKeys(uname);
		password.sendKeys(pwd);
		lgbtn.click();
		Thread.sleep(2000);
	}
	public void ExplicitWait(WebElement webElement, int time)
	  {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
	  }
		

		public void SwitchToHomePage() {
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String handle : allWindowHandles) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);

				}
			}
		}

	public void EventBtn() throws InterruptedException {

//		Thread.sleep(1000);
		ExplicitWait(event,1);
		event.click();
	}

	public void eventname(String ename) {
		eventname.sendKeys(ename);
	}

	public void NextBtn() {
		next.click();
	}

	public void postEvent() {
		post.click();
	}

	/* ===========Connection Sorting================== */
	@FindBy(xpath = "//span[@title=\"My Network\"]")
	WebElement Ntw;

	public void NtwIcon() throws InterruptedException {
		ExplicitWait(Ntw,2);
		Ntw.click();
	}

	@FindBy(xpath = "//div[@class=\"mn-community-summary__sub-section artdeco-dropdown__item\"]/child::a[@href=\"/mynetwork/invite-connect/connections/\"]")
	WebElement connection;

	public void consort() throws InterruptedException {
		ExplicitWait(connection,2);
		connection.click();
	}

	@FindBy(xpath = "//div[@class=\"artdeco-dropdown artdeco-dropdown--placement-bottom artdeco-dropdown--justification-left ember-view\"]/child::button")
	WebElement dropdown;

	public void dropdownConnection() throws InterruptedException {
//		Thread.sleep(2000);
		ExplicitWait(dropdown,2);
		dropdown.click();
	}

	@FindBy(xpath = "//span[text()=\"First name\"]")
	WebElement firstname;

	public void first() throws InterruptedException {
		Thread.sleep(2000);
		firstname.click();
	}
	
	@FindBy(xpath="//p[text()='Sort by:']")
	WebElement sort;
	public String SortText() {
		return sort.getText();
	}
//-------------------------------------
	@FindBy(xpath = "//div[@class=\"mn-community-summary__sub-section artdeco-dropdown__item\"]/child::a[@href=\"/mynetwork/network-manager/events/?source=community-summary\"]")
	WebElement Events;

	public void Events2() throws InterruptedException {
//		Thread.sleep(2000);
		ExplicitWait(Events,2);
		Events.click();
	}

	@FindBy(xpath = "//a[text()='h']")
	WebElement name;
	@FindBy(xpath = "(//span[text()='Share'])")
	WebElement share;

	public void eventext() throws InterruptedException {
//		Thread.sleep(2000);
		ExplicitWait(name,2);
		name.click();
	}

	public void scroll() throws InterruptedException {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();

		Thread.sleep(3000);
	}

	public void sharebtn() throws InterruptedException, AWTException {
		ExplicitWait(share,1);
		share.click();
	}

	public void ClickRepost() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
//		Thread.sleep(1000);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
		robot.delay(2000);
	}

	@FindBy(xpath = "//div[@class=\"ql-editor\"]/child::p[1]")
	WebElement Clear;
	@FindBy(xpath = "//div[@data-placeholder=\"What do you want to talk about?\"]")
	WebElement Enterdata;

	public void clearingText() throws InterruptedException {
		Clear.sendKeys(Keys.CONTROL + "a");
		Clear.sendKeys(Keys.BACK_SPACE);
//		Thread.sleep(2000);
		ExplicitWait(Enterdata,2);
		Enterdata.sendKeys("Please join on time.");
	}

	@FindBy(xpath = "//button[@class=\"share-actions__primary-action artdeco-button artdeco-button--2 artdeco-button--primary ember-view\"]")
	WebElement ClickPost;

	public void ClickPostBtn() {
		ClickPost.click();
	}

	// ========================================================
	@FindBy(xpath = "//button[@aria-label=\"Create event\"]")
	WebElement CreateEventbtn;

	public void ClickbtnEvent() {
		CreateEventbtn.click();
	}

	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextEvent;

	public void nextbtnEvent() {
		nextEvent.click();
	}

	@FindBy(xpath = "//input[@id=\"ef-form__name\"]")
	WebElement EnterName;

	public void EventName(String string) {
		EnterName.click();
		EnterName.sendKeys(string);

	}

	@FindBy(xpath = "//button[@aria-label=\"Schedule post\"]")
	WebElement schedulebtn;

	public void scheduleBtnClick() throws InterruptedException {
		ExplicitWait(schedulebtn,2);
		schedulebtn.click();
	}
	
	// ---------------------------------------------------------
	public void ClickInvite() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
	}

	@FindBy(xpath = "//input[@aria-label=\"Search by name\"]")
	WebElement EnterCompany;

	public void CmpName() {
		EnterCompany.click();
	}

	@FindBy(xpath = "//input[@aria-label=\"Search by name\"]")
	WebElement EnterCmp;

	public void EventCm(String string1) throws InterruptedException {

		ExplicitWait(EnterCmp,2);
		EnterCmp.sendKeys(string1);

	}
     @FindBy(xpath="//h3[text()='Invite']")
     WebElement inviteText;
     
     public String text() {
    	 return inviteText.getText();
     }
}
