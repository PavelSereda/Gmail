package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MessagePage extends AbstractPage {

	@FindBy(xpath = "//a[contains(@href, 'mail-settings.google.com/mail')]")
	private WebElement confirmationLink;

	@FindBy(xpath = "//a[contains(text(), 'Inbox')]")
	private WebElement inboxMessageButton;

	@FindBy(xpath = "//span[@class = 'gD']")
	private WebElement senderName;

	@FindBy(xpath = "//span[@class = 'aV3 a6U']")
	private WebElement attachment;
	
	@FindBys(@FindBy(xpath = "//span[@class = 'aV3 a6U']"))
	private List<WebElement> checkAattachment;

	@FindBy(xpath = "//img[@class = 'ajz']")
	private WebElement showDetailsButton;

	@FindBy(xpath = "//span[contains(text(), 'Important')]")
	private WebElement importanseText;
	
	@FindBys(@FindBy(xpath = "//span[contains(text(), 'Important')]"))
	private List<WebElement> checkImportanseText;

	public MessagePage(WebDriver driver) {
		super(driver);
	}

	public ConfirmationPage goToConfirmation() {
		wait.waitForElementIsClickable(confirmationLink);
		confirmationLink.click();
		return new ConfirmationPage(driver);
	}

	public HomePage goToHomePage() {
		wait.waitForElementIsClickable(inboxMessageButton);
		inboxMessageButton.click();
		return new HomePage(driver);
	}

	public boolean checkTheLetterWithAttachIsInTrashAndMarkAsImportant(String name, String attachmentName) {
		wait.waitForElementIsClickable(showDetailsButton);
		if ((name.equals(senderName.getText())) && (attachmentName.equals(attachment.getText()))) {
			showDetailsButton.click();
			if (importanseText.isDisplayed()) {
				return true;
			}
		}
		showDetailsButton.click();
		return false;
	}

	public boolean checkTheLetterWithoutAttachIsInInboxAndNotMarkAsImportant(String name) {
		wait.waitForElementIsClickable(showDetailsButton);
		if ((name.equals(senderName.getText()) && checkAattachment.size() == 0)) {
			showDetailsButton.click();
			if (checkImportanseText.size() == 0) {
				return true;
			}
		}

		return false;
	}
	
	public boolean checkTheLetterWithoutAttachIsInInbox(String name) {
		wait.waitForElementIsClickable(showDetailsButton);
		if ((name.equals(senderName.getText()) && checkAattachment.size() == 0)) {
			return true;
		}
		return false;
	}
}
