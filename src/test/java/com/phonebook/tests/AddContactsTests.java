package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactsTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().LoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegistrationLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        //click on Login button
        app.getUser().clickOnLoginButton();
    }



    @Test
    @Parameters({"name", "lastName", "phone", "email", "address", "desc"})
    public void addContactPositiveTest(String name, String lastName, String phone,
                                       String email, String address, String desc){
        //click Add link
        app.getContact().clickOnAddLink();
        //enter Name
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastName(lastName)
                .setPhone( phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        //click on Save button
        app.getContact().clickOnSavedButton();
        //assert by text
        Assert.assertTrue(app.getContact().isContactAddedByText(name));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().deleteContact();
        app.getUser().pause(1000);
    }



    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone,
                                       String email, String address, String desc){
        //click Add link
        app.getContact().clickOnAddLink();
        //enter Name
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastName(lastName)
                .setPhone( phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        //click on Save button
        app.getContact().clickOnSavedButton();
        //assert by text
        Assert.assertTrue(app.getContact().isContactAddedByText(name));
    }


    @Test(dataProvider = "addContactFromCsv", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderWithCsvTest(Contact contact){
        //click Add link
        app.getContact().clickOnAddLink();
        //enter Name
        app.getContact().fillContactForm(contact);

        //click on Save button
        app.getContact().clickOnSavedButton();
        //assert by text
        Assert.assertTrue(app.getContact().isContactAddedByText(contact.getName()));
    }

}







