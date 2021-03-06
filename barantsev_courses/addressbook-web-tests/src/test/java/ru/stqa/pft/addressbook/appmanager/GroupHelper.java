package ru.stqa.pft.addressbook.appmanager;

import ru.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper {
    FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {

        this.wd = wd;
    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());

      }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
      }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
      }

    public void returnToGroupPage() { wd.findElement(By.xpath("/html/body/div/div[4]/div/i/a")).click(); }

    public void deleteSelectedGroups() {
      wd.findElement(By.xpath("/html/body/div/div[4]/form/input[5]")).click();
    }

    public void selectGroup() { wd.findElement(By.xpath("/html/body/div/div[4]/form/span/input")).click(); }
}
