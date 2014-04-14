package ua.lviv.testers.testcase.testcategories.logintests;


import java.io.File;
import org.openqa.selenium.By;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.lviv.testers.pages.enterapp.LoginPage;
import ua.lviv.testers.testcase.testcategories.LoginPageTest;
import ua.lviv.testers.webdriver.WebDriverFactory;


public class LoginPageTestSuite extends LoginPageTest{
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 2.1
	public void enterAdminPageView() throws InterruptedException{
		LoginPage login = home.loginAdminPage(getUsermail(), getPassword());
		Thread.sleep(4000); // to see that it works
		Assert.assertTrue(login.isAvatarDisplayed(), "Avatar is not displayed");
	}
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 2.2
	public void registerNew() throws InterruptedException{
		//LoginPage login = home.loginAdminPage(getUsermail(), getPassword());
		ScreenRegion s = new DesktopScreenRegion();
		File buttonPathFile = new File("src\\main\\resources\\sikuli-images\\register.png");                
        Target imageTarget = new ImageTarget(buttonPathFile);
        ScreenRegion r = s.wait(imageTarget, 7000);
        //r = s.find(imageTarget);
        Mouse mouse = new DesktopMouse();
        mouse.click(r.getCenter());
        //TODO with PageOBject
        /*String textPost = eventDriver.findElement(By.id("icon-edit")).findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(textPost, "Add New Post");*/
	}
}
