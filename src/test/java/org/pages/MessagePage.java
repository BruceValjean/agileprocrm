package org.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.Driver;

import java.util.List;

public class MessagePage  {

    public MessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "span.feed-add-post-micro-title")
    public WebElement sendMessage;








   // @FindBy(css = "button[type='submit']")
    // public WebElement processOrderBtn;
    


}
