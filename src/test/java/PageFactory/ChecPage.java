package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChecPage {
    @FindBy (id = "remove-sauce-labs-backpack")
    WebElement remove1 ;

    @FindBy (id="remove-sauce-labs-bolt-t-shirt")
    WebElement remove2 ;

    @FindBy (id="checkout")
    WebElement checkout ;

    @FindBy (id="first-name")
    WebElement Fname ;

    @FindBy(id= "last-name")
    WebElement Lname ;

    @FindBy(id="postal-code")
    WebElement zip ;

    @FindBy(id="continue")
    WebElement continuee ;

    @FindBy(id="finish")
    WebElement finish ;

    WebDriver driver ;
    public ChecPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void setRemove1(){
        remove1.click();
    }
    public void setRemove2(){
        remove2.click();
    }
public  void setCheckout(){
        checkout.click();
}

    public void setFname(String fname){
        Fname.sendKeys(fname);
    }

public void setLname(String lname){

        Lname.sendKeys(lname); ;

}

public void setZip(String Zip ){
    zip.sendKeys(Zip);
}

public void setContinuee(){

        continuee.click();
}

public void setFinish(){

        finish.click();
}
}
