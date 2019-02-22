package package1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {
		
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement tabWomen;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement tabDresses;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tabTshirts;
	@FindBy(xpath="//*[@id='newsletter-input']")
	private WebElement txtBoxNewsLetter;
	@FindBy(xpath="//*[@id='newsletter_block_left']/h4")
	private WebElement txtSubscription;
	@FindBy(xpath="//*[@id='newsletter_block_left']/div/form/div/button")
	private WebElement submitNewsletter;
	@FindBys(@FindBy(xpath="//*[@id='columns']/p"))
	private List<WebElement> Product;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	public void clickWomen(){
		tabWomen.click();
			}
	public void clickDresses(){
		tabDresses.click();
	}
	public void clickTshirts(){
		tabTshirts.click();
	}
	public void setTxtNewsLetter(String email){
		setText(txtBoxNewsLetter, email);
		}
	public void clicksubmitletter(){
		submitNewsletter.click();
	}
	public String getSubscribedText(){
		return txtSubscription.getAttribute("value");
	}
	public List<WebElement>getProduct(){
		return Product;
	}

}