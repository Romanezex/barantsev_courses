package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/* It is the layer of interacting with tested system
*/

public class ApplicationManager {
    FirefoxDriver wd;

    private NavigationHelper navigationHelper ;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
    }
  }

    public void init() {
      System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
      wd = new FirefoxDriver();
      wd.manage().window().setSize(new Dimension(1552, 840));
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("https://localhost/addressbook/group.php");
      sessionHelper = new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
      navigationHelper = new NavigationHelper(wd);
      groupHelper = new GroupHelper(wd);

    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void stop() {
        wd.quit();
    }
}
