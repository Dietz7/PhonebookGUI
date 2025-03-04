package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpButtonPresent() {
        return isElementPresent(By.cssSelector(".navbar-logged_nav__2Hx7M button"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegistrationLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        //enter password
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean LoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.cssSelector(".navbar-logged_nav__2Hx7M button"));
    }
}
