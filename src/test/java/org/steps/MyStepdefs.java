package org.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.MessagePage;
import org.utilities.ConfigurationReader;
import org.utilities.Driver;

import javax.swing.*;

public class MyStepdefs {
    public String messageWritten="testMessage";
    MessagePage messagePage = new MessagePage();

    @Given("User in on the main page")
    public void userInOnTheMainPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebElement username = Driver.getDriver().findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        username.sendKeys("hr2@cybertekschool.com");

        WebElement password = Driver.getDriver().findElement(By.xpath("(//input[@class='login-inp'])[2]"));
                password.sendKeys("UserUser");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("(//input[@type='submit'])"));
                loginButton.click();

    }

    @When("user clicks message text area")
    public void user_clicks_message_text_area() {

      // Driver.getDriver().findElement(By.cssSelector("span.feed-add-post-micro-title")).click();

        messagePage.sendMessage.click();

        // Write code here that turns the phrase above into concrete actions

    }



    @When("user writes {string} text")
    public void user_writes_message(String str) {
        // Write code here that turns the phrase above into concrete actions

       messageWritten = str;


        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.cssSelector("iframe.bx-editor-iframe")));
        Driver.getDriver().findElement(By.tagName("body")).sendKeys(str);
        Driver.getDriver().switchTo().parentFrame();

    }

    @When("user clicks message send button")
    public void user_clicks_message_send_button() {
        // Write code here that turns the phrase above into concrete actions

        WebElement sendButton =Driver.getDriver().findElement(By.id("blog-submit-button-save"));
        sendButton.click();
    }

    @When("user sees the message in the active stream")
    public void user_sees_the_message_in_the_active_stream() {
        // Write code here that turns the phrase above into concrete actions

        System.out.println(messageWritten);
       // System.out.println(Driver.getDriver().findElement(By.cssSelector("div.feed-post-text-block-inner-inner")).getText());

        Assert.assertEquals(messageWritten,Driver.getDriver().findElement(By.cssSelector("div.feed-post-text-block-inner-inner")).getText());

    }
}
