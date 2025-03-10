package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().LoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Andreas")
                .setLastName("Kan")
                .setPhone( "1234567890")
                .setEmail("test@gmail.com")
                .setAddress( "Berlin")
                .setDescription( "goalkeeper"));
        app.getContact().clickOnSavedButton();
    }

    @Test
    public void deleteContactPositiveTest() {
        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}