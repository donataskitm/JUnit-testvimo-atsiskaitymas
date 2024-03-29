import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forma {
    public static final String SEARCH_BUTTON_BY_XPATH = "//button[@name='insert']";

    private static WebDriver browser;

    public static void main (String [] args){ //args gauti vartotojo parametrus
        System.out.println ("Selenium + Maven + JUnit");
        getResults();
    }

    public static void setup(){
        //sujungiamas kodas su narsykle
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver91.exe"); //kelias iki driver

        browser = new ChromeDriver();
        browser.get("http://kitm.epizy.com/filmai.php");
    }

    public static void insert(String keywordPav, String keywordZan, String keywordAkt, String keywordRez, Integer keywordTruk ){

        WebElement pavadinimasField = browser.findElement(By.name("pavadinimas"));
        pavadinimasField.sendKeys(keywordPav);
        //pavadinimasField.sendKeys(Keys.ENTER);

        WebElement zanrasField = browser.findElement(By.name("zanras"));
        zanrasField.sendKeys(keywordZan);


        WebElement aktoriaiField = browser.findElement(By.name("aktoriai"));
        aktoriaiField.sendKeys(keywordAkt);


        WebElement rezisieriusField = browser.findElement(By.name("rezisierius"));
        rezisieriusField.sendKeys(keywordRez);


        WebElement trukmeField = browser.findElement(By.name("trukme"));
        trukmeField.sendKeys(String.valueOf(keywordTruk));



        WebElement ele = browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();", ele);


    }

    public static String getResults(){

       //WebElement result2 = browser.findElement(By.className("msg-good"));
        WebElement result2 = browser.findElement(By.cssSelector("body > *:last-child"));

        String resultStr = result2.getText();


        return resultStr;
    }

    public static void close(){
        browser.close();
    }
}


