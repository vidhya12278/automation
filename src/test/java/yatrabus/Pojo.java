package yatrabus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends Helperclass
{
public Pojo()
{
	PageFactory.initElements(driver,this);
}

@FindBy(xpath="//input[@type='text']")
private WebElement search;

@FindBy(xpath="(//input[@class='gNO89b'])[2]")
private WebElement searchbutton;

@FindBy(xpath="(//h3[@class='LC20lb DKV0Md'])[1]")
private WebElement firstlink;

@FindBy(xpath="//span[text()='Book Flights, Hotels and Holiday Packages']")
private WebElement fighttitle;

@FindBy(xpath="(//label[@class='inp-focus'])[1]")
private WebElement depart;

public WebElement getSearch() {
	return search;
}

public WebElement getSearchbutton() {
	return searchbutton;
}

public WebElement getFirstlink() {
	return firstlink;
}

public WebElement getFighttitle() {
	return fighttitle;
}

public WebElement getDepart() {
	return depart;
}

//@FindBy(xpath="")






}
