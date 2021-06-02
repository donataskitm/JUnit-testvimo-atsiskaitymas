import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forma1 {
    public static final String SEARCH_BUTTON_BY_XPATH = "//button[@name='delete']";

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

    public static void insert(Integer keywordNum ){

        WebElement numerisField = browser.findElement(By.name("id"));
        numerisField.sendKeys(String.valueOf(keywordNum));
        //pavadinimasField.sendKeys(Keys.ENTER);

        WebElement ele = browser.findElement(By.xpath(SEARCH_BUTTON_BY_XPATH));
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();", ele);

    }

    public static String getResults(){

        //WebElement result2 = browser.findElement(By.className("msg-good"));
        WebElement result2 = browser.findElement(By.cssSelector("body > *:last-child"));

        String resultStr = result2.getText();

        System.out.println(result2);
        return resultStr;
    }

    public static void close(){
        browser.close();
    }
}


