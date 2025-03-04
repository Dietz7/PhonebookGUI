package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().LoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test(enabled=false)
    public void createNewUserPositiveTest() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on Registration
        app.getUser().clickOnRegistrationButton();
        //assert Sign Up button is present
        Assert.assertTrue(app.getUser().isSignUpButtonPresent());
    }

    @Test(groups="negative")
    public void createNewUserNegativeTest() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on Registration
        app.getUser().clickOnRegistrationButton();
        //assert Alert is present
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
