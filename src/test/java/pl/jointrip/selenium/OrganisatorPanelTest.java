package pl.jointrip.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import pl.jointrip.selenium.abstractTest.AbstractTest;

public class OrganisatorPanelTest extends AbstractTest {

    @Test
    public void testOrganisatorPanel() throws Exception {
        driver.get(baseUrl);
        login("admin@gmail.com", "qwe123");
        actions.moveToElement(driver.findElement(By.id("tripsLink"))).perform();
        driver.findElement(By.id("myTripsLink")).click();
        driver.findElement(By.id("paidMemberTabLink")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/div/div/div[2]/div/div/div[3]/div/div/div[2]/div/a[2]")).click();

    }

}
