package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addSLback ;


    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addSLBSh ;

    @FindBy (id="react-burger-menu-btn")
    WebElement Menu ;

    @FindBy (id="logout_sidebar_link")
    WebElement logout ;


    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement chariot ;


WebDriver driver ;
    public HomePage(WebDriver driver){
        this.driver= driver ;
        PageFactory.initElements(driver,this);


    }

    public void setAddSLback() {
        addSLback.click();
    }

    public void setAddSLBSh() {
        addSLBSh.click();
    }

    public void setMenu(){
        Menu.click();
    }

    public void setLogout() {
         logout.click();
    }
    public void setChariot(){
        chariot.click();
    }
}
