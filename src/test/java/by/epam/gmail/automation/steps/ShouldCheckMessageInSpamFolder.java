package by.epam.gmail.automation.steps;

import by.epam.gmail.automation.runner.RunGmailTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ShouldCheckMessageInSpamFolder extends RunGmailTest {


	@When("^User send message \"([^\"]*)\" to another user with email \"([^\"]*)\"$")
	public void sendMessage(String message,String email) {
		homePage.sendMessage(email,message);
	}

	@When("^User navigate to default window$")
	public void switchToDefaultWindow() {
		homePage.switchToDefaultWindow();
	}
	@When("^User log out$")
	public void logOut() {
		homePage.logOut();
	}

	@When("^User switch to another profile$")
	public void addAndSwitchUser() {
		switchUserPage.addAndSwitchUser();
	}
	@When("^User switch to another one$")
	public void switchUser() {
		switchUserPage.switchUser();
	}

	@When("^User authorizate with following login and password \"([^\"]*)\",\"([^\"]*)\"$")
	public void authorizate(String login, String password) {
		loginPage.authorization(login,password);
	}


	@When("^User marks received message as spam$")
	public void transportToSpam() {
		homePage.markMessageAsSpam();
	}

	@Then("^Check that message from \"([^\"]*)\" is in spam folder$")
	public void checkSenderName(String senderName) {
		Assert.assertTrue(spamPage.checkSenderName(senderName));
	}

}
