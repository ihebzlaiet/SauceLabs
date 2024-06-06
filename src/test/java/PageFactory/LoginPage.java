package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement Username;

    @FindBy(id ="password")
    WebElement Password ;

    @FindBy(id="login-button")
    WebElement Login ;

    WebDriver driver ;
    public LoginPage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);


    }
    public void setUsername(String name){
        Username.sendKeys(name);

    }
    
    public void setPassword(String pass){
        Password.sendKeys(pass);
    }
    public void setLogin (){
        Login.click();
    }
}
