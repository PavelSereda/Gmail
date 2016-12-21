package by.epam.gmail.automation.steps;

import by.epam.gmail.automation.runner.RunGmailTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ShouldCheckWarningMessageBecauseOfImproperExtension extends RunGmailTest {


	@When("^User navigate to settings page$")
	public void navigateToSettingsPage() {
		homePage.goToSettingsPage();
	}
	@When("^User navigate to theme page$")
	public void navigateToThemePage() {
		generalSettingsPage.goToThemesPage();
	}

	@When("^User select photo \"([^\"]*)\" from computer$")
	public void selectPhotoFromComputer(String photoName) {
		themesPage.selectPhotosFromComputer(photoName);
	}

	@Then("^User see warning message$")
	public void checkWarningMessage(){
		Assert.assertTrue(themesPage.checkWarningMessage());
	}


}
