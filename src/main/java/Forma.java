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



       /* //2. neveikia nes naudoja javascript

         WebDriverWait wait2 = new WebDriverWait(browser, 2);
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH)).click();

       //3. neveikia nes naudoja javascript
        WebDriverWait wait1 = new WebDriverWait(browser,10);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_BUTTON_BY_XPATH)));
        element1.click();
        */
    }

    public static String getResults(){

       WebElement result2 = browser.findElement(By.className("msg-good"));

       String resultStr = result2.getText();

       System.out.println(result2);
        return resultStr;
    }

    public static void close(){
        browser.close();
    }
}


