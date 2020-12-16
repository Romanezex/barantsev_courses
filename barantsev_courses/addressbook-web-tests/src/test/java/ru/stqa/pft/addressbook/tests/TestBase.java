package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {




/* This class initialize each test method before it is executed and finishes it. But the real
   interaction with tested system is implemented in Application manager class */


  protected ApplicationManager app = new ApplicationManager();

  @BeforeMethod
    public void setUp() throws Exception{
      app.init();
    }


  @AfterMethod
    public void tearDown() {
      app.stop();
    }

  }

