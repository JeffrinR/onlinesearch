package package2;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import package1.Basepage;
import package1.Homepage;
import package1.dressesPage;

public class Testscript {
	Homepage hp;
	Basepage bp;
	dressesPage dp;
	int value=new Random().nextInt(30000);
	String email="TestAutomationJeff" + value + "@yahoo.com";
	public Testscript(){
		hp=new Homepage();
		bp =new Basepage();
		dp=new dressesPage();
	}
	@Test
	public void verifyTabNavigation() {
	hp.clickWomen();
	Assert.assertTrue(hp.getTitle().contains("Women"), "Failed: Navigation failed for women");
	hp.navigateBack();
	hp.clickDresses();
	Assert.assertTrue(hp.getTitle().contains("Dresses"), "Failed: Navigation failed for dresses");
	hp.navigateBack();
	hp.clickTshirts();
	Assert.assertTrue(hp.getTitle().contains("T-shirts"), "Failed: Navigation failed for T-shirts");
	//hp.navigateBack();
	}
	@Test
	public void verifyNewsLetter() {
		hp.setTxtNewsLetter(email);
		hp.clicksubmitletter();
		Assert.assertTrue(hp.getSubscribedText().contains("successfully"), "Failed: Not subscribed");
	}
	@Test
	public void verifyproductCount(){
		hp.clickDresses();
		Assert.assertEquals(dp.getcountfromheader()==dp.productcount(), "Failed: count mismatched");
}
}
