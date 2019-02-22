package package1;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class dressesPage extends Basepage{
	@FindBy(xpath="//*[@id='center_column']/h1/span[2]")
	private WebElement txtProductHeader;
	@FindBys(@FindBy(xpath="//*[@id='center_column']/ul"))
	private List<WebElement> firstproduct;
	
	public dressesPage(){
		PageFactory.initElements(driver, this);
	}
	public int getcountfromheader(){
		String txt=txtProductHeader.getText();
		String[] arr=txt.split(" ");
		txt=arr[2];
		int number=Integer.parseInt(txt);
		return number;
		//return Integer.parseInt(txtProductHeader.getText().split("")[2]);
	}
	public int productcount(){
		return firstproduct.size();
	}
}
