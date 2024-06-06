package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {

    WebDriver driver;

    public ElementUtil(WebDriver driver) {

        this.driver = driver;
    }

    //MEthode pour verifier que la chaine existe dans la page

    public void validation(String msg) {

        String pagecontent = driver.findElement(By.tagName("html")).getText();
        List<String> motrechrche = new ArrayList<>();

        motrechrche.add(msg);
        for (String mot : motrechrche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  existe sur la page");
            } else {
                System.out.println("le mot " + mot + " n'existe pas sur la page");
            }

        }
    }

    //Confirmation le lien
    public void confirmation(String Url) {
        String expectedURL = Url;
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    //défiler la page vers le bas d'un nombre spécifié de pixels
    public void javaScriptscrollByPixels(int pixels) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0," + pixels + ");");

    }

    //défiler la page jusqu'à la fin (bas) de la page.
    public void javaScriptscrollToBottom() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }



    // défiler la page jusqu'à ce que l'élément spécifié soit visible
    public void javaScriptscrollToElement(WebElement element, String textToBeTyped) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //méthodes alert
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.accept();
    }

    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForalert(durationInSeconds);
        alert.dismiss();
    }

    public Alert waitForalert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            System.out.println("alert is not present");
        }
        return alert;

    }


}