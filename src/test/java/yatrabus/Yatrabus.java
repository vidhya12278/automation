package yatrabus;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Yatrabus extends Helperclass 
{
	
	public static void main(String[] args) throws InterruptedException
    {
	browser();
	Pojo p=new Pojo();
	title();
	currenturl();
	send(p.getSearch(),"yatrabus");
	getattribute(p.getSearch());
	Thread.sleep(1000);
	buttonclick(p.getSearchbutton());
	//actionclick(p.getSearchbutton());
	
	gettext(p.getFighttitle());
	select(p.getDepart());
	
	}

}
