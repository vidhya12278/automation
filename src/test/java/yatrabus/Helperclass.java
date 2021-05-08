package yatrabus;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.support.ui.Select;

public class Helperclass 
{
   static WebDriver driver;
   static Actions a;
   static Robot r;
   static JavascriptExecutor js ;
   static TakesScreenshot t;
   static Select s;
	public static WebDriver browser() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\dev\\automationconcept\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void title() 
	{
		String k = driver.getTitle();
		System.out.println("browser title: " + k);
	}
	
	public static void currenturl()
	{
		String h = driver.getCurrentUrl();
		System.out.println("browser currenturl : " + h);
	}
	
	public static void send(WebElement u,String text) 
	{
		u.sendKeys(text);
    }
	
	public static void gettext(WebElement y) 
	{
		String k = y.getText();
		System.out.println("text : " + k);
	}
	public static void getattribute(WebElement y) 
	{
		String n = y.getAttribute("value");
		System.out.println("content : " + n);
	}
	public static void button(WebElement y) 
	{
		y.click();
	}
	
	//actions
	public static void movetoelement(WebElement y) 
	{
		a=new Actions(driver);
		a.moveToElement(y).perform();
	}
	public static void draganddrop(WebElement y,WebElement p)
	{
		a.dragAndDrop(y, p).perform();
    }
	public static void doubleclick(WebElement y) 
	{
	a.doubleClick(y).perform();
    }
	
	public static void rightclick(WebElement y) 
	{
    a.contextClick(y).perform();
    }
	public static void actionclick(WebElement r) 
	{
		a.click(r).perform();

	}
	
	//robotclass
	public static void robot(WebElement y) throws AWTException 
	{
	 r=new Robot();
	for (int i = 0; i < 4; i++) 
	{
	r.keyPress(KeyEvent.VK_ENTER);	
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	}

	public static void copypaste() 
	{
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_V);
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_V);
    }
	
	//javascript
	public static void sendjava(WebElement r,WebElement u) 
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','r')",u);
	}
	public static void buttonclick(WebElement r) 
	{
		js.executeScript("arguments[0].click();",r);
    }
	
	public static void down(WebElement r)
	{
		js.executeScript("arguments[0].scrollIntoView(true)",r);
    }
	
	public static void Ups(WebElement r) 
	{
		js.executeScript("arguments[0].scrollIntoView(false)", r);
    }
	public static void highlight(WebElement r) 
	{
     js.executeScript("arguments[0].setAttribute('style','background:red');", r);
	}
	
	public static void screenshot(WebElement r) throws IOException 
	{
		 t=(TakesScreenshot)driver;
         File src = t.getScreenshotAs(OutputType.FILE);
         File desc = new File("C:\\Users\\user\\Desktop\\dev\\automationconcept\\screenshotss\\ .jpeg");
	     FileUtils.copyFile(src, desc);
	}
	public static void enabled(WebElement j) 
	{
		boolean o = j.isEnabled();
		System.out.println("true or not :  " + o);

	}
	
	public static void displayed(WebElement j)
	{
		boolean o = j.isDisplayed();
		System.out.println("true or not :  " + o);
	}
	
	public static void selected(WebElement j)
	{
		boolean o = j.isSelected();
		System.out.println("true or not :  " + o);
	}
	
	public static void navigate(String url) 
	{
	driver.navigate().to(url);	
    }
	
	public static void forward() 
	{
		driver.navigate().forward();
    }
	public static void back() 
	{
		driver.navigate().back();
	}
	public static void refresh()
	{
		driver.navigate().refresh();
    }
	
	public static void windows(WebElement u,WebElement i) 
	{
	 String parid = driver.getWindowHandle();
	 Set<String> all = driver.getWindowHandles();
	 for (String n : all) 
	 {
		if(!(parid.equals(n)))
		{
			driver.switchTo().window(n);
		}
	}
}

	public static void select(WebElement o) 
	{
	  s=new Select(o);
	  List<WebElement> h = s.getOptions();
	  int l = h.size();
	  for (int i = 0; i < l; i++)
	  {
		WebElement k = h.get(l);
		System.out.println("content : " + k.getText());
	}
}
	public void allselected(WebElement h) 
	{
		List<WebElement> c = s.getAllSelectedOptions();
		for (WebElement w : c) 
		{
			System.out.println("content : " + w.getText());
		}
	}
	
	public static void firstselected(WebElement h) 
	{
		WebElement j = s.getFirstSelectedOption();
		System.out.println("content : " + j.getText());
    }
	
	public static void multiple(WebElement h) 
	{
	boolean g = s.isMultiple();	
	System.out.println("true or false : " + g);
    }
	
	public static String getData(int  rowno, int colno) throws IOException
	{
		File f=new File("C:\\Users\\user\\Desktop\\dev\\Data\\Excel1\\Data.xlsx");
		FileInputStream g=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(g);
		Sheet s= w.getSheet("Sheet1");
		Row p = s.getRow(rowno);	
		org.apache.poi.ss.usermodel.Cell x = p.getCell(colno);
		CellType cellType = x.getCellType();
		String value="";
		if(cellType==CellType.STRING)
		{
			value = x.getStringCellValue();
		}
		else
			if(cellType==CellType.NUMERIC)
			{
				if(DateUtil.isCellDateFormatted(x))
				{
					Date d = x.getDateCellValue();
					SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
					 value = sm.format(d);
	    		}
				else {
					double u = x.getNumericCellValue();
					long l=(long)u;
					value = String.valueOf(l);
							}
			}
	    return value;
		}
	
	
	
	
	
	
	
	
	
}
