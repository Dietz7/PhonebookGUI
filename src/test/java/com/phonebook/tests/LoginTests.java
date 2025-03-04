package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.fw.ApplicationManager.softAssert;

public class LoginTests extends TestBase {
   // @BeforeClass
   // public void beforeClass(){
   //     System.out.println("*********Before class");
    //}

    //@AfterClass
    //public void afterClass(){
       // System.out.println("**********After class");
  //  }

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().LoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        //login
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Up button is Present
        Assert.assertTrue(app.getUser().isSignUpButtonPresent());
    }
@Test (groups="negative")
    public void loginNegativeWithoutEmailTest() {
        //login
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegistrationLoginForm(new User()
                .setPassword(UserData.PASSWORD));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //assert Sign Up button is present
        softAssert.assertTrue(app.getUser().isAlertPresent());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());

        softAssert.assertAll();
    }

}
